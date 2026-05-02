package payment;

import model.PaymentRequest;
import model.PaymentResult;

public class HumoPaymentProcessor implements PaymentProcessor{

    @Override
    public PaymentResult process(PaymentRequest request) {
        System.out.println("Humo bank API ga so'rov yuborildi...");
        System.out.println("Karta: " + request.getCardNumber());
        System.out.println("Summa: " + request.getAmount());
        return new PaymentResult(true,"dddgdf","to'lov amalga oshi",null);
    }

    @Override
    public boolean supports(String cardNumber) {
        return cardNumber.startsWith("9860");
    }

    @Override
    public PaymentResult refund(String TransactionId) {
        System.out.println("Humo orqali qaytarish: " + TransactionId);
        return new PaymentResult(true, TransactionId, "Qaytarildi", null);
    }
}
