package me.potato.graphqlplayground.sec01.lec03;

import lombok.RequiredArgsConstructor;
import me.potato.graphqlplayground.sec01.lec03.dto.Customer;
import me.potato.graphqlplayground.sec01.lec03.dto.CustomerOrder;
import me.potato.graphqlplayground.sec01.lec03.service.CustomerService;
import me.potato.graphqlplayground.sec01.lec03.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService    orderService;

    @QueryMapping
    public Flux<Customer> customers() {
        return customerService
                .getAllCustomers();
    }

    @SchemaMapping(typeName = "Customer")
    public Flux<CustomerOrder> orders(Customer customer, @Argument Integer limit) {
        return orderService
                .getOrdersByNameOrEmpty(customer.getName())
                .take(limit);
    }
}
