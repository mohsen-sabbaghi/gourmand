package com.example.gourmand.app.service.mapper;

import com.example.gourmand.app.dto.RecipeDto;
import com.example.gourmand.app.entitiy.Recipe;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Recipe} and its DTO {@link RecipeDto}.
 */
@Mapper(uses = {
        RecipeInstructionMapper.class,
        IngredientsMapper.class,
        }, componentModel = "spring")
public interface RecipeMapper extends EntityMapper<RecipeDto, Recipe> {
}
