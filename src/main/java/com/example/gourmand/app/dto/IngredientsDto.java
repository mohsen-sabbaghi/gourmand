package com.example.gourmand.app.dto;

import com.example.gourmand.app.entitiy.enums.UnitsEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IngredientsDto extends BaseDto {

    @SerializedName("ingredients_name")
    @Expose
    private String ingredientsName;

    @SerializedName("ingredients_description")
    @Expose
    private String ingredientsDescription;

    @SerializedName("ingredients_type")
    @Expose
    private String ingredientsType;

    @SerializedName("required_amount")
    @Expose
    private String requiredAmount;

    @SerializedName("unit")
    @Expose
    private UnitsEnum unitsEnum;
}
