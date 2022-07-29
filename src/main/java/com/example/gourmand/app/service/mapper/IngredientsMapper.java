package com.example.gourmand.app.service.mapper;

import com.example.gourmand.app.dto.IngredientsDto;
import com.example.gourmand.app.dto.RecipeDto;
import com.example.gourmand.app.entitiy.Ingredients;
import com.example.gourmand.app.entitiy.Recipe;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Recipe} and its DTO {@link RecipeDto}.
 */
@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface IngredientsMapper extends EntityMapper<IngredientsDto, Ingredients> {
}
