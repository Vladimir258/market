package ru.geekbrains.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.entities.User;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    public void createOrder(User user) {
//        Cart cart = new Cart();
//        Order order = new Order();
//        cart.getItems().stream().map(cartItem -> {
//           new OrderItem(null, productService.findById(cartItem.getProductId()), order);
//        });
    }
}
