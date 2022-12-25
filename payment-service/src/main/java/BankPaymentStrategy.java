public class BankPaymentStrategy implements PaymentStrategy {

    private final String email;
    private final String token;

    public BankPaymentStrategy(String email, String token) {
        this.email = email;
        this.token = token;
    }

    @Override
    public void pay(Money amount) {
        System.out.printf("processing %s via Bank account %s\n",
                amount.toString(), email);
    }
}
