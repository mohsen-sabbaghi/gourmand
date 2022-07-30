package com.example.exceptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.Expose;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */

@Getter
@Setter
@Builder
@Schema(name = "ErrorDetails", description = "Error Details")
public class ErrorDetail {


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Schema(name = "time", description = "error date time")
    private Date time;

    @Schema(name = "message", example = "An error occurred", description = "error message")
    private String message;
    @Schema(name = "exceptionType", example = "ApiException", description = "Exception Type")
    private ExceptionTypeEnum exceptionType;

    /**
     * Exception Type
     */
    public enum ExceptionTypeEnum {
        EXCEPTION("Exception"),

        API_EXCEPTION("ApiException"),

        NOT_FOUND_EXCEPTION("NotFoundException");

        @Expose
        private final String value;

        ExceptionTypeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ExceptionTypeEnum fromValue(String value) {
            for (ExceptionTypeEnum b : ExceptionTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
