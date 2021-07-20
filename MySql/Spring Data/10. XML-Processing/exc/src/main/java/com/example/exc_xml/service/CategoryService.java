package com.example.exc_xml.service;


import com.example.exc_xml.model.dto.CategorySeedDto;
import com.example.exc_xml.model.dto.CategorySeedRootDto;

import java.util.List;

public interface CategoryService {

    void seedCategories (List<CategorySeedDto> categories);

    long getCount ();
}
