package com.example.gourmand.entitiy;

import com.example.gourmand.entitiy.enums.BakingToolsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recipe_instruction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeInstruction extends BaseEntity {

    @Column(name = "instruction", columnDefinition = "TEXT", length = 2000)
    private String instruction;

    @Enumerated(EnumType.STRING)
    @Column(name = "baking_tool")
    private BakingToolsEnum bakingToolsEnum = BakingToolsEnum.OVEN;

    @Column(name = "prepare_time")
    private Integer prepareTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Recipe recipe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instruction, that.instruction) && Objects.equals(prepareTime, that.prepareTime) && Objects.equals(cookTime, that.cookTime) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instruction, prepareTime, cookTime, recipe);
    }
}
