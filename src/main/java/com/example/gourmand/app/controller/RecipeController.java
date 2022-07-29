package com.example.gourmand.app.controller;

import com.example.gourmand.app.dto.RecipeDto;
import com.example.gourmand.app.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    @Value("${server.port}")
    private int serverPort;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(
            operationId = "getAllRecipes",
            summary = "get All Recipes",
            tags = {"recipes"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "recipes fetched")
            }
    )
    @GetMapping(path = {"", "/"}, produces = "application/json")
    public ResponseEntity<Page<RecipeDto>> getAllRecipes(
            @Parameter(name = "pageSize", example = "5") @RequestParam(required = false, defaultValue = "5") Integer pageSize
            , @Parameter(name = "pageNumber", example = "0") @RequestParam(required = false, defaultValue = "0") Integer pageNumber
    ) {
        log.debug("#REST request to get All Recipes ");
        return new ResponseEntity<>(recipeService.getAllRecipes(pageSize, pageNumber), HttpStatus.OK);
    }

    @GetMapping(path = "/{recipe-id}", produces = "application/json")
    public ResponseEntity<RecipeDto> getOneRecipes(@PathVariable("recipe-id") Long id) {
        log.debug("REST request to get Recipe : {}", id);
        if (recipeService.findOne(id).isPresent()) {
            return ResponseEntity.ok().body(recipeService.findOne(id).get());
        }
        return ResponseEntity.noContent().build();
    }

//    @GetMapping(path = "/recipes/{recipe-category}", produces = "application/json")
//    public ResponseEntity<List<RecipeDto>> getAllRecipesByCat(@PathVariable("recipe-category") String cat) {
//        log.debug("REST request to get All Recipe of specific category : {}", cat);
//        RecipeCategory recipeCategory = new RecipeCategory();
//        recipeCategory.setRecipeCategoryName(cat);
////        return ResponseEntity.ok().body(recipeService.findAllByCategory(recipeCategory));
//        return null;
//    }

}
