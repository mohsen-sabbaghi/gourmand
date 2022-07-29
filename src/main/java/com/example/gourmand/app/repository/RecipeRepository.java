package com.example.gourmand.app.repository;

import com.example.gourmand.app.entitiy.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, CustomUserRepository {

}
