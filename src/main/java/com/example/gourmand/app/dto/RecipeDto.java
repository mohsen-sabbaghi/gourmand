package com.example.gourmand.app.dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeDto extends BaseDto {

    @SerializedName("recipe_name")
    @Expose
    private String recipeName;

    @SerializedName("number_of_servings")
    @Expose
    private Integer numberOfServings = 1;

    @SerializedName("recipe_ingredients")
    @Expose
    private Set<IngredientsDto> ingredientsSet = new HashSet<>();

    @SerializedName("recipe_instructions")
    @Expose
    private RecipeInstructionDto recipeInstructions;

}
