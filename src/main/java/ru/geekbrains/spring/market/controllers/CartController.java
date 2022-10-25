package ru.geekbrains.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.market.models.Cart;
import ru.geekbrains.spring.market.services.CartService;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Cart getCurrentCart() {
            return cartService.getCurrentCart();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductFromCartById(@PathVariable Long id) {
        cartService.del(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clearCrt();
    }
}
