package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */
@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(value = {GourmandApiException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDetail apiException(GourmandApiException ex) {
        return ErrorDetail.builder()
                .exceptionType(ErrorDetail.ExceptionTypeEnum.API_EXCEPTION)
                .message(ex.getMessage())
                .time(new Date())
                .build();
    }

    @ExceptionHandler(value = {RecipeNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetail notFoundException(GourmandApiException ex) {
        return ErrorDetail.builder()
                .exceptionType(ErrorDetail.ExceptionTypeEnum.NOT_FOUND_EXCEPTION)
                .message(ex.getMessage())
                .time(new Date())
                .build();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDetail unKnownException(Exception ex) {
        return ErrorDetail.builder()
                .exceptionType(ErrorDetail.ExceptionTypeEnum.EXCEPTION)
                .message("Unexpected Error occurred: "+ex.getMessage())
                .time(new Date())
                .build();
    }

}
