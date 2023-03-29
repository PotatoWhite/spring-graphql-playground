package me.potato.graphqlplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.potato.graphqlplayground.sec01.lec04")
public class GraphqlPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlPlaygroundApplication.class, args);
    }

}
