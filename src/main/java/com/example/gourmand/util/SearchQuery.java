package com.example.gourmand.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

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

public class SearchQuery {
    private List<SearchFilter> searchFilters;
    @Schema(description = "page number", example = "0")
    private int pageNumber;
    @Schema(description = "page size", example = "10")
    private int pageSize;
    @Schema(hidden = true)
    private SortOrder sortOrder;
    private List<JoinColumnProps> joinColumnProps;
}
