package com.example.gourmand.app.entitiy;

import com.example.gourmand.app.entitiy.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * @author m-sabbaghi
 * https://www.linkedin.com/in/sabbaghi/
 * @version 7/24/2022
 */

@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredients extends BaseEntity {

    @NotNull
    @Size(min = 2)
    @Column(name = "ingredients_name", nullable = false)
    private String ingredientsName;

    @Column(name = "ingredients_description")
    private String ingredientsDescription;

    @Column(name = "ingredients_type")
    private String ingredientsType;

    @Column(name = "required_amount")
    private String requiredAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private UnitsEnum unitsEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false, foreignKey = @ForeignKey(name = "fk_recipe_ingredient"))
    private Recipe recipe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingredients that = (Ingredients) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
