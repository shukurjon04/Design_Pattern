package model;

public class PaymentRequest {
    private String TransactionId;
    private String CardNumber;
    private double amount;
    private String currency;
    private String paymentType;

    public PaymentRequest(String transactionId, String cardNumber, double amount, String currency, String paymentType) {
        TransactionId = transactionId;
        CardNumber = cardNumber;
        this.amount = amount;
        this.currency = currency;
        this.paymentType = paymentType;
    }

    public PaymentRequest() {
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
