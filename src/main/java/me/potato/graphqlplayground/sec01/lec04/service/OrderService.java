package me.potato.graphqlplayground.sec01.lec04.service;

import me.potato.graphqlplayground.sec01.lec04.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class OrderService {
    private final Map<String, List<CustomerOrder>> orders = Map.of(
            "John", List.of(
                    CustomerOrder.of(UUID.randomUUID(), "Order 1"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 2"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 3")
            ),
            "Jane", List.of(
                    CustomerOrder.of(UUID.randomUUID(), "Order 4"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 5"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 6")
            )
    );

    public Flux<CustomerOrder> getOrdersByNameOrEmpty(String name) {
        return Flux.fromIterable(
                orders.getOrDefault(name, Collections.emptyList()
                )
        );

    }

    public Flux<List<CustomerOrder>> getOrdersByNames(List<String> names) {
        return Flux
                .fromIterable(names)
                .flatMap(n -> fetchOrders(n).defaultIfEmpty(Collections.emptyList()));
    }

    private Mono<List<CustomerOrder>> fetchOrders(String name) {
        return Mono.justOrEmpty(orders.get(name))
                .delayElement(Duration.ofSeconds(1));
    }
}
