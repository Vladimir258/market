package ru.geekbrains.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.entities.Order;
import ru.geekbrains.spring.market.entities.User;
import ru.geekbrains.spring.market.models.Cart;
import ru.geekbrains.spring.market.models.CartItem;
import ru.geekbrains.spring.market.repositories.OrderRepository;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final CartItem cartItem;
    private Cart cart;

    public Order createOrderForCurrentUser(User user, Order orderDetails) {
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(cartItem.getPrice());
//        order.setItems(cart.getItems());
//        for (OrderItem oi : cart.getItems()) {
//            oi.setOrder(order);
//        }
        order.setPhone(orderDetails.getPhone());
        order = orderRepository.save(order);
        cart.clearS();
        return order;
    }

    public void createOrder(User user) {
    }

    public Collection<Object> findAllByUser(Long userId) {
        return orderRepository.findAllById(userId);
    }

//    public List<Order> findAllByUser(Long userId) {
//        return orderRepository.findAllById(userId);
//    }


 //   public void createOrder(User user) {
//        Cart cart = new Cart();
//        Order order = new Order();
//        cart.getItems().stream().map(cartItem -> {
//           new OrderItem(null, productService.findById(cartItem.getProductId()), order);
//        });
}

