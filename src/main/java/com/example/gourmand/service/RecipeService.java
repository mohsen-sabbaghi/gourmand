package com.example.gourmand.service;

import com.example.gourmand.dto.RecipeDto;
import com.example.gourmand.entitiy.Recipe;
import com.example.gourmand.util.SearchQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RecipeService  {

    RecipeDto save(RecipeDto RecipeDto);

    RecipeDto update(RecipeDto RecipeDto);

    Optional<RecipeDto> partialUpdate(RecipeDto RecipeDto);

    Page<RecipeDto> getAllRecipes(int pageSize, int pageNumber);

    Optional<RecipeDto> findOne(Long id);

    public Page<RecipeDto> searchRecipes(SearchQuery searchQuery);

    void delete(Long id);



}
