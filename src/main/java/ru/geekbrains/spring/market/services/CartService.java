package ru.geekbrains.spring.market.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.entities.Product;
import ru.geekbrains.spring.market.repositories.CartRepository;

@Service
@RequiredArgsConstructor
@Getter
public class CartService {
    private final CartRepository cartRepository;

    public void addToCart(Product product) {
        cartRepository.getCart().add(product);

    }

    public void deleteByCart(Product product) {
        cartRepository.getCart().remove(product);
    }


}
