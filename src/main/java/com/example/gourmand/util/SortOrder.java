package com.example.gourmand.util;

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

public class SortOrder {
    private List<String> ascendingOrder;

    private List<String> descendingOrder;
}
