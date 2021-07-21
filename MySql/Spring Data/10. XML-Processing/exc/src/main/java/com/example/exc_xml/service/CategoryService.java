package com.example.exc_xml.service;


import com.example.exc_xml.model.dto.CategorySeedDto;
import com.example.exc_xml.model.dto.CategorySeedRootDto;
import com.example.exc_xml.model.enitity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories (List<CategorySeedDto> categories);

    long getCount ();

    Set<Category> getRandomCategories();
}
