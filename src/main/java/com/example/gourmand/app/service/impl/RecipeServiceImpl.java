package com.example.gourmand.app.service.impl;

import com.example.gourmand.app.dto.RecipeDto;
import com.example.gourmand.app.entitiy.Recipe;
import com.example.gourmand.app.repository.RecipeRepository;
import com.example.gourmand.app.service.RecipeService;
import com.example.gourmand.app.service.mapper.RecipeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private final RecipeMapper recipeMapper;
    private final RecipeRepository recipeRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public RecipeServiceImpl(RecipeMapper recipeMapper, RecipeRepository recipeRepository) {
        this.recipeMapper = recipeMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeDto save(RecipeDto recipeDto) {
        log.debug("Request to save Recipe : {}", recipeDto);
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        recipe = recipeRepository.save(recipe);
        return recipeMapper.toDto(recipe);
    }

    @Override
    public RecipeDto update(RecipeDto recipeDto) {
        log.debug("Request to save/update Recipe : {}", recipeDto);
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        recipe = recipeRepository.save(recipe);
        return recipeMapper.toDto(recipe);
    }

    @Override
    public Optional<RecipeDto> partialUpdate(RecipeDto recipeDto) {
        log.debug("Request to partially update Recipe : {}", recipeDto);
        return recipeRepository.findById(recipeDto.getId()).map(existingRecipe -> {
            recipeMapper.partialUpdate(existingRecipe, recipeDto);
            return existingRecipe;
        }).map(recipeRepository::save).map(recipeMapper::toDto);
    }

    @Override
    public Page<RecipeDto> getAllRecipes(int pageSize, int pageNumber) {
        log.debug("#Service - Request to get all Recipes");
        return recipeRepository.findAll(PageRequest.of(pageNumber, pageSize == 0 ? 10 : pageSize))
                .map(recipeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RecipeDto> findOne(Long id) {
        log.debug("Request to get Recipe : {}", id);
        return recipeRepository.findById(id).map(recipeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Recipe : {}", id);
        recipeRepository.deleteById(id);
    }

}
