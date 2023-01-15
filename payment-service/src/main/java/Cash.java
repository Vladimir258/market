import java.math.BigDecimal;
import java.util.Currency;

public class Cash extends Money {
    public Cash(Currency currency, BigDecimal amount) {
        super(currency, amount);
    }

    public Cash(Currency currency, double amount) {
        super(currency, amount);
    }
}
