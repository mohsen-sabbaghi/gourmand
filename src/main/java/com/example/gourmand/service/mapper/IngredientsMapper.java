package com.example.gourmand.service.mapper;

import com.example.gourmand.dto.IngredientsDto;
import com.example.gourmand.dto.RecipeDto;
import com.example.gourmand.entitiy.Ingredients;
import com.example.gourmand.entitiy.Recipe;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Recipe} and its DTO {@link RecipeDto}.
 */
@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface IngredientsMapper extends EntityMapper<IngredientsDto, Ingredients> {
}
