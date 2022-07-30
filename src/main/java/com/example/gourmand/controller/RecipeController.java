package com.example.gourmand.controller;

import com.example.exceptions.ErrorDetail;
import com.example.gourmand.aspects.Loggable;
import com.example.gourmand.dto.RecipeDto;
import com.example.gourmand.service.RecipeService;
import com.example.gourmand.util.SearchQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
                    @ApiResponse(responseCode = "200", description = "recipes retrieved")
            }
    )
    @Loggable
    @GetMapping(path = {"", "/"}, produces = "application/json")
    public ResponseEntity<Page<RecipeDto>> getAllRecipes(
            @Parameter(name = "pageSize", example = "5") @RequestParam(required = false, defaultValue = "5") Integer pageSize
            , @Parameter(name = "pageNumber", example = "0") @RequestParam(required = false, defaultValue = "0") Integer pageNumber
    ) {
        log.debug("#REST request to get All Recipes ");
        return new ResponseEntity<>(recipeService.getAllRecipes(pageSize, pageNumber), HttpStatus.OK);
    }

    @Operation(
            operationId = "retrieveRecipeById",
            summary = "retrieve a recipe",
            tags = {"getRecipes"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Retrieve a recipe by id", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid input, invalid Id", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Recipe Not Found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
                    })
            }
    )
    @Loggable
    @GetMapping(path = "/{recipe-id}", produces = "application/json")
    public ResponseEntity<RecipeDto> getOneRecipes(@PathVariable("recipe-id") Long id) {
        log.debug("REST request to get Recipe : {}", id);
        Optional<RecipeDto> recipeDto = recipeService.findOne(id);
        return recipeDto.map(r -> ResponseEntity.ok().body(r))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            operationId = "createRecipe",
            summary = "create a new recipe",
            tags = {"recipes"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "new recipe created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = RecipeDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "invalid input, object invalid", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
                    })
            }
    )
    @Loggable
    @PostMapping(value = "", produces = {"application/json"}, consumes = {"application/json"}
    )
    public ResponseEntity<RecipeDto> saveRecipe(
            @Parameter(name = "RecipeDto") @RequestBody(required = false) RecipeDto recipeDto
    ) {
        return new ResponseEntity<>(recipeService.save(recipeDto), HttpStatus.CREATED);
    }

    @Operation(
            operationId = "searchRecipe",
            summary = "search Recipe",
            tags = { "recipes" },
            responses = {@ApiResponse(responseCode = "200", description = "recipes fetched")}
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/search",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<Page<RecipeDto>> searchRecipe(@RequestBody SearchQuery searchRecipeRequest){
        return new ResponseEntity<>(recipeService.searchRecipes(searchRecipeRequest), HttpStatus.OK);
    }


}
