package ru.geekbrains.spring.market.dtos;

import lombok.*;
import ru.geekbrains.spring.market.entities.Product;
import java.util.*;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    // todo если продукт с таким id уже есть, применить счетчик продуктов
    public void add(Product product) {
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item: items) {
            totalPrice += item.getPrice();
        }
    }
}
