package com.example.gourmand.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author m-sabbaghi
 * <a href="https://www.linkedin.com/in/sabbaghi/">...</a>
 * @version 7/30/2022
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SearchFilter {
    @Schema(description = "entity property name", example = "instructions")
    private String columnName;
    @Schema(description = "operator", example = "EQUALS", format = "enum")
    private QueryOperator operator;
    @Schema(description = "value of the filter. Use arrays for IN operator", example = "5")
    private Object value;
}
