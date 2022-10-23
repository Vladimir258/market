package ru.geekbrains.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.market.entities.Product;
import ru.geekbrains.spring.market.services.CartService;
import java.util.List;

@RestController
@RequestMapping("api/v1/products/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductController productController;

    @GetMapping
    public List<Product> showCart() {
            return cartService.getCartRepository().getCart();
    }

    @GetMapping("/{id}")
    public void addInCart(@PathVariable Long id) {
        cartService.addToCart(productController.findProductById(id));
        showCart();
    }

    @DeleteMapping("/{id}")
    public void deleteProductFromCartById(@PathVariable Long id) {
        cartService.deleteByCart(productController.findProductById(id));
        showCart();
    }
}
