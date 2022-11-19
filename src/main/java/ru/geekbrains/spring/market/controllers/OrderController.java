package ru.geekbrains.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.market.entities.Order;
import ru.geekbrains.spring.market.entities.User;
import ru.geekbrains.spring.market.services.OrderService;
import ru.geekbrains.spring.market.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final UserService userService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal/*, @RequestBody OrderData orderData*/) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException());
        orderService.createOrder(user);
    }

    @GetMapping
    @Transactional
    public List<Order> getAllOrdersForCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user.getId()).stream().map(Order::new).collect(Collectors.toList());
    }
}
