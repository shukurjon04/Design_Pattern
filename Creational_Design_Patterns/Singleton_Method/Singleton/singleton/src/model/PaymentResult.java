package model;

public class PaymentResult {
    private boolean success;
    private Long TransactionId;
    private String message;
    private String errorCode;

    public PaymentResult(boolean success, Long transactionId, String message, String errorCode) {
        this.success = success;
        TransactionId = transactionId;
        this.message = message;
        this.errorCode = errorCode;
    }

    public PaymentResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Long transactionId) {
        TransactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
