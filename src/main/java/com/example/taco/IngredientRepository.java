package com.example.taco;

import java.util.Optional;
import com.example.taco.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
