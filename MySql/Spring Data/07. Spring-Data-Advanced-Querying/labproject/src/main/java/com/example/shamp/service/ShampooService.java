package com.example.shamp.service;

import com.example.shamp.entities.Shampoo;
import com.example.shamp.entities.Size;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySizeOrderById (Size size);

    List<Shampoo> findAllBySizeOrLabelOrderByPrice (Size size,Long label_id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc (BigDecimal price);

    int countAllByPriceLessThan (BigDecimal price);

    List<String> findAllByIngredientsNames (Collection<String> names);

    List<String> findAllByIngredientsCounts (long ingredientCount);



}
