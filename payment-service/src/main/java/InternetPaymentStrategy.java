public class InternetPaymentStrategy implements PaymentStrategy{
    private final String email;
    private final String cart;

    public InternetPaymentStrategy(String email, String cart) {
        this.email = email;
        this.cart = cart;
    }

    @Override
    public void pay(Money amount) {
        System.out.printf("processing %s via Internet account %s\n",
                amount.toString(), email, cart);
    }
}
