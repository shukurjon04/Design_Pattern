package service;

import factory.PaymentProcessFactory;
import model.PaymentRequest;
import model.PaymentResult;
import payment.PaymentProcessor;

public class PaymentService {

    public PaymentResult tolovQil(PaymentRequest request) {


        PaymentProcessor processor = PaymentProcessFactory
            .getByCardNumber(request.getCardNumber());


        PaymentResult result = processor.process(request);


        if (result.isSuccess()) {
            System.out.println("To'lov tasdiqlandi: "
                + result.getTransactionId());
        } else {
            System.out.println("To'lov rad etildi. Sabab: "
                + result.getErrorCode());
        }

        return result;
    }
}