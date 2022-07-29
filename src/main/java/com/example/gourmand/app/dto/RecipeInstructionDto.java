package com.example.gourmand.app.dto;

import com.example.gourmand.app.entitiy.enums.BakingToolsEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecipeInstructionDto extends BaseDto {

    @SerializedName("instruction")
    @Expose
    private String instruction;

    @SerializedName("prepare_time")
    @Expose
    private Integer prepareTime;

    @SerializedName("cook_time")
    @Expose
    private Integer cookTime;

    @SerializedName("baking_tool")
    @Expose
    private BakingToolsEnum bakingToolsEnum = BakingToolsEnum.OVEN;
}
