package com.example.gourmand.app.service.mapper;

import com.example.gourmand.app.dto.RecipeInstructionDto;
import com.example.gourmand.app.entitiy.RecipeInstruction;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link RecipeInstruction} and its DTO {@link RecipeInstructionDto}.
 */
@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface RecipeInstructionMapper extends EntityMapper<RecipeInstructionDto, RecipeInstruction> {
}
