package com.example.gourmand.util;

import lombok.ToString;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */
@ToString

public enum QueryOperator {
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL_TO,
    LESS_THAN,
    LESS_THAN_OR_EQUAL_TO,
    EQUALS,
    LIKE,
    NOT_EQ,
    IN,
    IS_NULL,
    IS_NOT_NULL,
    FULL_TEXT_SEARCH
}
