package ru.geekbrains.spring.market.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.market.entities.Product;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Service
@Scope("singleton")
public class CartRepository {
    private List<Product> cart;

}
