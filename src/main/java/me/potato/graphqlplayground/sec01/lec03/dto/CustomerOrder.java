package me.potato.graphqlplayground.sec01.lec03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CustomerOrder {
    private UUID   id;
    private String description;
}
