package me.potato.graphqlplayground.sec01.lec02.service;

import me.potato.graphqlplayground.sec01.lec02.controller.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    private final Flux<Customer> customers = Flux.just(
            Customer.of(1, "John", 20, "New York"),
            Customer.of(2, "Jane", 21, "London"),
            Customer.of(3, "Jack", 22, "Paris"),
            Customer.of(4, "Jill", 23, "Tokyo")
    );

    public Flux<Customer> getAllCustomers() {
        return customers;
    }

    public Mono<Customer> getCustomerById(Integer id) {
        return customers.filter(c -> c.getId().equals(id)).next();
    }

    public Flux<Customer> getCustomersByName(String name) {
        return customers.filter(c -> c.getName().contains(name));
    }
}
