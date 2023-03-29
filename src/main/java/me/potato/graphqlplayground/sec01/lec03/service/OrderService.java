package me.potato.graphqlplayground.sec01.lec03.service;

import me.potato.graphqlplayground.sec01.lec03.dto.CustomerOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private final Map<String, Flux<CustomerOrder>> orders = Map.of(
            "John", Flux.just(
                    CustomerOrder.of(UUID.randomUUID(), "Order 1"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 2"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 3")
            ),
            "Jane", Flux.just(
                    CustomerOrder.of(UUID.randomUUID(), "Order 4"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 5"),
                    CustomerOrder.of(UUID.randomUUID(), "Order 6")
            )
    );

    public Flux<CustomerOrder> getOrdersByNameOrEmpty(String name) {
        return orders.getOrDefault(name, Flux.empty());
    }
}
