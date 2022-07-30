package com.example.exceptions;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */
public class GourmandApiException extends RuntimeException{

    public GourmandApiException() {
    }

    public GourmandApiException(String message) {
        super(message);
    }
}
