package factory;

import payment.HumoPaymentProcessor;
import payment.PaymentProcessor;
import payment.UzcardPaymentProcessor;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessFactory {
    private static final List<PaymentProcessor> processes = new ArrayList<>();

    static {
        processes.add(new HumoPaymentProcessor());
        processes.add(new UzcardPaymentProcessor());
    }

    public static PaymentProcessor getByCardNumber(String cardNumber){
        return processes.stream()
                .filter(p->p.supports(cardNumber))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException(
                        "Bu karta qo'llab quvvatlanmaydi "+cardNumber
                ));
    }

    public static PaymentProcessor getByType(String type) {
        return switch (type.toLowerCase()) {
            case "humo"   -> new HumoPaymentProcessor();
            case "uzcard" -> new UzcardPaymentProcessor();
            default -> throw new IllegalArgumentException(
                    "Noma'lum to'lov turi: " + type
            );
        };
    }
}
