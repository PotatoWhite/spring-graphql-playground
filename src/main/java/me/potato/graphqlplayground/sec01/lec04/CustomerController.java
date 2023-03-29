package me.potato.graphqlplayground.sec01.lec04;

import lombok.RequiredArgsConstructor;
import me.potato.graphqlplayground.sec01.lec04.dto.Customer;
import me.potato.graphqlplayground.sec01.lec04.dto.CustomerOrder;
import me.potato.graphqlplayground.sec01.lec04.service.CustomerService;
import me.potato.graphqlplayground.sec01.lec04.service.OrderService;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

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

    @BatchMapping(typeName = "Customer")
    public Flux<List<CustomerOrder>> orders(List<Customer> list) {
        return orderService
                .getOrdersByNames(list.stream().map(Customer::getName).toList());
    }
}
