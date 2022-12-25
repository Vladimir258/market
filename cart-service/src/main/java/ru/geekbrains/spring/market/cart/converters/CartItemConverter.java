package ru.geekbrains.spring.market.cart.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.api.CartItemDto;
import ru.geekbrains.spring.market.cart.utils.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem c) {
        return new CartItemDto(c.getProductId(), c.getProductTitle(), c.getQuantity(), c.getPricePerProduct(), c.getPrice());
    }
}
