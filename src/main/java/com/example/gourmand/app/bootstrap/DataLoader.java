package com.example.gourmand.app.bootstrap;

import com.example.gourmand.app.entitiy.Ingredients;
import com.example.gourmand.app.entitiy.Recipe;
import com.example.gourmand.app.entitiy.RecipeInstruction;
import com.example.gourmand.app.entitiy.enums.BakingToolsEnum;
import com.example.gourmand.app.entitiy.enums.UnitsEnum;
import com.example.gourmand.app.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("!prod")
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final Environment environment;
    private final RecipeRepository recipeRepository;

    public DataLoader(Environment environment, RecipeRepository recipeRepository) {
        this.environment = environment;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("#mock data is generating.....");
        loadData();
        log.info("#mock data is generated.");
        log.debug("#Currently active profile - " + Arrays.toString(environment.getActiveProfiles()));
    }

    private void loadData() {

        Recipe recipe = new Recipe();
        recipe.setRecipeName("recipe Name");

        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstruction("1.Preheat the oven to 425 °F. Coat two sheet pans with cooking spray and set aside.\n" +
                "\n" +
                "2.Place gnocchi, tomatoes, bell pepper, zucchini, squash, and chicken sausage in a large bowl. Add the olive oil, garlic, basil, oregano, salt, and black pepper. Gently toss together until everything is evenly coated in oil and seasonings.\n" +
                "\n" +
                "3.Divide the mixture between the two sheet pans. Place both pans in the oven and cook for 10 minutes, then stir. Cook for another 10to 15 minutes or until the chicken sausage begins to crisp, the gnocchi turns light golden brown, and the vegetables are caramelized.\n" +
                "\n" +
                "4.Top with fresh parsley or basil and serve with grated parmesan cheese.");
        recipeInstruction.setBakingToolsEnum(BakingToolsEnum.GAS_STOVE);
        recipeInstruction.setCookTime(15);
        recipeInstruction.setPrepareTime(20);
        recipeInstruction.setRecipe(recipe);
        recipe.setRecipeInstructions(recipeInstruction);

        Set<Ingredients> ingredientsSet = new HashSet<>();

        Ingredients ingredients = new Ingredients();
        ingredients.setIngredientsName("onion");
        ingredients.setRequiredAmount("3");
        ingredients.setUnitsEnum(UnitsEnum.MEDIUM);
        ingredients.setIngredientsType("veg");
        ingredients.setRecipe(recipe);

        Ingredients ingredients2 = new Ingredients();
        ingredients2.setIngredientsName("mushroom");
        ingredients2.setRequiredAmount("200");
        ingredients2.setUnitsEnum(UnitsEnum.GRAMS);
        ingredients2.setIngredientsType("veg");
        ingredients2.setRecipe(recipe);

        ingredientsSet.add(ingredients);
        ingredientsSet.add(ingredients2);

        recipe.setIngredientsSet(ingredientsSet);
        recipe.setNumberOfServings(4);


        recipeRepository.save(recipe);

    }
}
