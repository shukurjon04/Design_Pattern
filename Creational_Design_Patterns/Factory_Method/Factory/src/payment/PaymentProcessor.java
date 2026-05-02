package payment;

import model.PaymentRequest;
import model.PaymentResult;

public interface PaymentProcessor {
    PaymentResult process(PaymentRequest request);
    boolean supports(String cardNumber);
    PaymentResult refund(String TransactionId);
}
