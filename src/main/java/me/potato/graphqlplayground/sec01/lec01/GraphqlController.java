package me.potato.graphqlplayground.sec01.lec01;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class GraphqlController {
    @QueryMapping(name = "sayHello")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World");
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument String name) {
        return Mono.fromSupplier(() -> "Hello " + name);
    }

    @QueryMapping
    public Mono<Integer> random() {
        return Mono.fromSupplier(() -> (int) (Math.random() * 100));
    }

    @QueryMapping
    public Mono<String> sayHelloDelay(@Argument String name) {
        return Mono.fromSupplier(() -> "Hello " + name).delayElement(Duration.ofSeconds(5));
    }
}
