package ru.geekbrains.spring.market.models;

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

    public void add(Product product) {
        for (CartItem i: items) {
            if(i.getProductId().equals(product.getId())) {
                i.setQuantity(i.getQuantity() + 1);
                i.setPrice(i.getPricePerProduct() * i.getQuantity());
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    public void del(Product product) {
        for (CartItem i: items) {
            if(i.getProductId().equals(product.getId()) & i.getQuantity() > 1) {
                i.setQuantity(i.getQuantity() - 1);
                i.setPrice(i.getPrice() - i.getPricePerProduct());
                recalculate();
                return;
            }
        }
        items.remove(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    public void clearS() {
        items.clear();
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item: items) {
            totalPrice += item.getPrice() ;
        }
    }
}
