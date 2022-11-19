package ru.geekbrains.spring.market.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public void incrementQuantity() {
        quantity++;
        price = price + pricePerProduct;
    }
}
