package payment;

import model.PaymentRequest;
import model.PaymentResult;

public class UzcardPaymentProcessor implements PaymentProcessor {

    public PaymentResult process(PaymentRequest request) {
        System.out.println("Uzcard processing center ga so'rov...");
        System.out.println("Karta: " + request.getCardNumber());
        System.out.println("Summa: " + request.getAmount());

        // Haqiqiy loyihada Uzcard o'z protokoli bilan ishlaydi
        // UzcardResponse response = uzcardGateway.authorize(...)

        return new PaymentResult(
            true,
            request.getTransactionId(),
            "Uzcard to'lovi tasdiqlandi",
            null
        );
    }

    public boolean supports(String cardNumber) {
        // Uzcard kartalari 8600 bilan boshlanadi
        return cardNumber.startsWith("8600");
    }

    public PaymentResult refund(String transactionId) {
        System.out.println("Uzcard orqali qaytarish: " + transactionId);
        return new PaymentResult(true, transactionId, "Qaytarildi", null);
    }
}