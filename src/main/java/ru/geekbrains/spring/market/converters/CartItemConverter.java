package ru.geekbrains.spring.market.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.*;
import ru.geekbrains.spring.market.models.CartItem;

@Component
public class CartItemConverter {
    public <CartItemDto> CartItemDto entityToDto(CartItem c) {
        return new CartItemDto(c.getProductId(), c.getProductTitle(), c.getQuantity(), c.getPricePerProduct(), c.getPrice());
    }
}
