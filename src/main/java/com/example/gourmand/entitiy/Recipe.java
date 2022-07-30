package com.example.gourmand.entitiy;

import com.example.gourmand.entitiy.enums.RecipeCategoryEnum;
import com.example.gourmand.entitiy.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author m-sabbaghi
 * https://www.linkedin.com/in/sabbaghi/
 * @version 7/24/2022
 */

@Entity
@Table(name = "recipe")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe extends BaseEntity {

    @NotNull
    @Size(min = 2)
    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Size(min = 1)
    @Column(name = "number_of_servings")
    private Integer numberOfServings = 1;

    @Enumerated(EnumType.STRING)
    @Column(name = "recipe_category")
    private RecipeCategoryEnum recipeCategoryEnum;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipe")
//    private Set<RecipeImage> recipeImages = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipe")
    private Set<Ingredients> ingredientsSet = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, mappedBy = "recipe")
    private RecipeInstruction recipeInstructions;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumns({
//            @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
//            @JoinColumn(name = "recipecategory_id", referencedColumnName = "id")
//    })
//    private Set<RecipeCategory> recipeCategorySet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return getId() != null && Objects.equals(getId(), recipe.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
