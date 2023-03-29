package me.potato.graphqlplayground.sec01.lec02.controller;

import lombok.RequiredArgsConstructor;
import me.potato.graphqlplayground.sec01.lec02.controller.dto.AgeRangeFilter;
import me.potato.graphqlplayground.sec01.lec02.controller.dto.Customer;
import me.potato.graphqlplayground.sec01.lec02.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    private final CustomerService customerService;

    @QueryMapping(name = "customerById")
    public Mono<Customer> getCustomerById(@Argument Integer id) {
        return customerService.getCustomerById(id);
    }

    @QueryMapping(name = "customersNameContains")
    public Flux<Customer> getCustomersByName(@Argument String name) {
        return customerService.getCustomersByName(name);
    }

    @QueryMapping(name = "customers")
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping(name = "customersByAgeRange")
    public Flux<Customer> getCustomersByAgeRange(@Argument AgeRangeFilter filter) {
        return customerService.getAllCustomers()
                .filter(c -> c.getAge() >= filter.getMinAge() && c.getAge() <= filter.getMaxAge());
    }
}
