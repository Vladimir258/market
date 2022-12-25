package ru.geekbrains.spring.market.cart.utils;

public class MultiCart extends OtherCart {
    public MultiCart(Cart cart) {
        super(cart);
    }

    @Override
    void add() {
        super.add();
        otherAdd();
    }

    public void otherAdd() {

    }
}
