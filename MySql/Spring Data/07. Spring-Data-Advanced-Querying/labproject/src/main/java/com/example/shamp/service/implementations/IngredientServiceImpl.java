package com.example.shamp.service.implementations;

import com.example.shamp.entities.Ingredient;
import com.example.shamp.repositories.IngredientsRepository;
import com.example.shamp.service.IngredientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientServiceImpl (IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith (String name) {
        return this.ingredientsRepository.findAllByNameStartingWith (name);
    }

    @Override
    public List<Ingredient> findAllByNameIn (Collection<String> name) {
        return this.ingredientsRepository.findAllByNameIn (name);
    }

    @Override
    public List<Ingredient> findAll () {
        return this.ingredientsRepository.findAll ();
    }

    @Override
    @Transactional
    public void deleteAllByName (String name) {
        this.ingredientsRepository.deleteAllByName (name);
    }

    @Override
    @Transactional
    public void updatePriceOfAll () {
        this.ingredientsRepository.updatePriceOfAll ();
    }

    @Override
    @Transactional
    public void updateIngredientsByNames (Collection<String> names) {
        this.ingredientsRepository.updateIngredientsByNames (names);
    }

}
