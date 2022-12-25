package ru.geekbrains.spring.market.core.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.api.OrderItemDto;
import ru.geekbrains.spring.market.core.entities.OrderItem;

@Component
public class OrderItemConverter {
    public OrderItemDto entityToDto(OrderItem o) {
        return new OrderItemDto(o.getProduct().getId(), o.getProduct().getTitle(), o.getQuantity(), o.getPricePerProduct(), o.getPrice());
    }
}
