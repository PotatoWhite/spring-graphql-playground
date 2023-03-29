package me.potato.graphqlplayground.sec01.lec03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Customer {
    private Integer id;
    private String  name;
    private Integer age;
    private String  city;

}
