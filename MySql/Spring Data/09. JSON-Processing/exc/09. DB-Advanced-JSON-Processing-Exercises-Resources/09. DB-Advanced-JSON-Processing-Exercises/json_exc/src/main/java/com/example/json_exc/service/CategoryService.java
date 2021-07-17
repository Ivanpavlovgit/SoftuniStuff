package com.example.json_exc.service;

import com.example.json_exc.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories () throws IOException;

    Set<Category> findRandomCategoriesSet();
}
