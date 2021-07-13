package com.example.shamp.service.implementations;

import com.example.shamp.entities.Shampoo;
import com.example.shamp.entities.Size;
import com.example.shamp.repositories.ShampooRepository;
import com.example.shamp.service.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl (ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySizeOrderById (Size size) {
        return this.shampooRepository.findAllBySizeOrderById (size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelOrderByPrice (Size size,Long label_id) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice (size,label_id);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc (BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc (price);
    }

    @Override
    public int countAllByPriceLessThan (BigDecimal price) {
        return this.shampooRepository.countAllByPriceLessThan (price);
    }

    @Override
    public List<String> findAllByIngredientsNames (Collection<String> names) {
        return this.shampooRepository
                .findAllByIngredientsNames (names)
                .stream ()
                .map (Shampoo::getBrand)
                .collect (Collectors.toList ());
    }

    @Override
    public List<String> findAllByIngredientsCounts (long ingredientCount) {
        return this.shampooRepository
                .findAllByIngredientsCounts (ingredientCount)
                .stream ()
                .map (Shampoo::getBrand)
                .collect (Collectors.toList ());
    }
}
