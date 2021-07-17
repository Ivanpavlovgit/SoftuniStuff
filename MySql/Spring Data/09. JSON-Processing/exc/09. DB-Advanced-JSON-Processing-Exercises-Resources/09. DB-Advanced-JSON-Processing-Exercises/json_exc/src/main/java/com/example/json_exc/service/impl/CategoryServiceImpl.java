package com.example.json_exc.service.impl;

import com.example.json_exc.model.Dto.CategorySeedDto;
import com.example.json_exc.model.entity.Category;
import com.example.json_exc.repository.CategoryRepository;
import com.example.json_exc.service.CategoryService;
import com.example.json_exc.utilities.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.json_exc.consts.GlobalConstants.FIRST_TASK_FOLDER_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private static final String CATEGORIES_FILE_NAME = "categories.json";

    public CategoryServiceImpl (CategoryRepository categoryRepository,Gson gson,ValidationUtil validationUtil,ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories () throws IOException {
        if (categoryRepository.count () > 0) {
            return;
        }
        var categoriesJSONAsString = Files
                .readString (Path.of (FIRST_TASK_FOLDER_PATH + CATEGORIES_FILE_NAME));
        CategorySeedDto[] categorySeedDtos = this.gson
                .fromJson (categoriesJSONAsString,CategorySeedDto[].class);

        Arrays.stream (categorySeedDtos)
                .filter (validationUtil::isValid)
                .map (categorySeedDto ->
                        modelMapper.map (categorySeedDto,Category.class))
                .forEach (this.categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategoriesSet () {
        Set<Category> categorySet = new HashSet<> ();
        int catCountForCurrentSet = ThreadLocalRandom
                .current ().nextInt (1,3);
        long totalCategoriesCount = this.categoryRepository.count ();
        for (int i = 0; i < catCountForCurrentSet; i++) {
            long randomId = ThreadLocalRandom.current ().nextLong (1,totalCategoriesCount + 1);
            categorySet.add (categoryRepository.findById (randomId).orElse (null));
        }
        return categorySet;


    }
}
