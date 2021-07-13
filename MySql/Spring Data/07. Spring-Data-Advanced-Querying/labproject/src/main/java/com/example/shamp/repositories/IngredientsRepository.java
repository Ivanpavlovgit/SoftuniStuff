package com.example.shamp.repositories;

import com.example.shamp.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface IngredientsRepository extends BaseRepository<Ingredient> {
    List<Ingredient> findAllByNameStartingWith (String name);

    List<Ingredient> findAllByNameIn (Collection<String> name);

    @Query("DELETE FROM Ingredient i WHERE i.name=:name")
    @Modifying
    void deleteAllByName (String name);

    @Query("UPDATE Ingredient i SET i.price=i.price*1.1")
    @Modifying
    void updatePriceOfAll ();

    @Query("UPDATE Ingredient i SET i.price=i.price*1.1 WHERE i.name IN :names")
    @Modifying
    void updateIngredientsByNames (Collection<String> names);
}
