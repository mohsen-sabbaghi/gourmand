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
public class JoinColumnProps {
    @Schema(description = "child entity property name", example = "description")
    private String joinColumnName;
    private SearchFilter searchFilter;
}
