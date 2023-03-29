package me.potato.graphqlplayground.sec01.lec02.controller.dto;

import lombok.Data;

@Data
public class AgeRangeFilter {
    private Integer minAge;
    private Integer maxAge;
}
