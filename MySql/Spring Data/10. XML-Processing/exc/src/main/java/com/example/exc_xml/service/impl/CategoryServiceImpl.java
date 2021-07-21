package com.example.exc_xml.service.impl;

import com.example.exc_xml.model.dto.CategorySeedDto;
import com.example.exc_xml.model.enitity.Category;
import com.example.exc_xml.repository.CategoryRepository;
import com.example.exc_xml.service.CategoryService;

import com.example.exc_xml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl (CategoryRepository categoryRepository,ModelMapper modelMapper,ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;

        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCategories (List<CategorySeedDto> categories) {

        categories
                .stream ()
                .filter (validationUtil::isValid)
                .map (categorySeedDto -> modelMapper.map (categorySeedDto,Category.class))
                .forEach (categoryRepository::save);

    }

    @Override
    public long getCount () {
        return this.categoryRepository.count ();
    }

    @Override
    public Set<Category> getRandomCategories () {
        Set<Category> categories = new HashSet<> ();
        var           count      = this.categoryRepository.count ();

        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom.current ().nextLong (1,count);
            categories.add (this.categoryRepository.findById (randomId).orElse (null));
        }

        return categories;
    }

}
