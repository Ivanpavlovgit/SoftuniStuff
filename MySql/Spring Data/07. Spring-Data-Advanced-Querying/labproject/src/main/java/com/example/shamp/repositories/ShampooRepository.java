package com.example.shamp.repositories;

import com.example.shamp.entities.Shampoo;
import com.example.shamp.entities.Size;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooRepository extends BaseRepository<Shampoo> {

    List<Shampoo> findAllBySizeOrderById (Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice (Size size,Long label_id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc (BigDecimal price);

    int countAllByPriceLessThan (BigDecimal price);

    @Query("SELECT DISTINCT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsNames (Collection<String> names);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i GROUP BY s.id HAVING COUNT(i) <:ingredientCount ")
    List<Shampoo> findAllByIngredientsCounts (long ingredientCount);

}
