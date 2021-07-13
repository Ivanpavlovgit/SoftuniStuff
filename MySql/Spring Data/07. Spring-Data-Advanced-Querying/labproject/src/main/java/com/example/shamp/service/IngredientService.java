package com.example.shamp.service;

import com.example.shamp.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith (String name);
    List<Ingredient> findAllByNameIn (Collection<String> name);
    List<Ingredient> findAll();

    void deleteAllByName (String name);
    void updatePriceOfAll ();
    void updateIngredientsByNames (Collection<String> names);

}
