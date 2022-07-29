package com.example.gourmand.app.service;

import com.example.gourmand.app.dto.RecipeDto;
import com.example.gourmand.app.repository.CustomUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface RecipeService extends CustomUserRepository {

    RecipeDto save(RecipeDto RecipeDto);

    RecipeDto update(RecipeDto RecipeDto);

    Optional<RecipeDto> partialUpdate(RecipeDto RecipeDto);

    public Page<RecipeDto> getAllRecipes(int pageSize, int pageNumber);

    Optional<RecipeDto> findOne(Long id);

    void delete(Long id);

}
