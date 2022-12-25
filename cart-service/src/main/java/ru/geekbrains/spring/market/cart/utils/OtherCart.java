package ru.geekbrains.spring.market.cart.utils;

public class OtherCart extends Cart {
    private final Cart cart;

    public OtherCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    void add() {
        cart.add();
    }
}
