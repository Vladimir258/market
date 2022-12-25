public class PayOrder {
    public void pay(PaymentStrategy strategy) {
        Money total = getTotal();
        strategy.pay(total);
    }

    public Money getTotal() {
        return null;
    }
}
