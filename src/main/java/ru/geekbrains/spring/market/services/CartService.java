package ru.geekbrains.spring.market.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.models.Cart;
import ru.geekbrains.spring.market.entities.Product;
import ru.geekbrains.spring.market.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Getter
public class CartService {
    private final ProductService productService;
   private Cart tempCart;

   @PostConstruct
   public void init() {
       tempCart = new Cart();
   }

   public Cart getCurrentCart() {
       return tempCart;
   }

    public void add(Long productId) {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Не удается добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
   }

    public void del(Long productId) {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Не удается удалить продукт с id: " + productId + " из корзины. Продукт не найден"));
        tempCart.del(product);
    }

    public void clearCrt() {
       tempCart.clearS();
    }
}
