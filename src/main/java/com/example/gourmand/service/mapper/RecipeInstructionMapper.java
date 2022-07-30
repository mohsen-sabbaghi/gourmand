package com.example.gourmand.service.mapper;

import com.example.gourmand.dto.RecipeInstructionDto;
import com.example.gourmand.entitiy.RecipeInstruction;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link RecipeInstruction} and its DTO {@link RecipeInstructionDto}.
 */
@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface RecipeInstructionMapper extends EntityMapper<RecipeInstructionDto, RecipeInstruction> {
}
