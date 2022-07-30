package com.example.exceptions;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */
public class RecipeNotFoundException extends GourmandApiException {
    public RecipeNotFoundException() {
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }
}
