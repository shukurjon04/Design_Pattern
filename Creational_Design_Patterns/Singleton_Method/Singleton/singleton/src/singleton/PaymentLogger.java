package singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PaymentLogger {
    private static volatile PaymentLogger paymentLogger;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

    private PaymentLogger(){
        System.out.println("Logger ishga tushdi");
    }

    public static PaymentLogger getInstance(){
        if (paymentLogger==null){
            synchronized (PaymentLogger.class){
                if (paymentLogger==null) {
                    paymentLogger=new PaymentLogger();
                }
            }
        }
        return paymentLogger;
    }

    public void info(Long transactionId , String message){
        System.out.println(
                "[INFO] " + now() + " | " + transactionId + " | " + message
        );
    }
    public void error(Long transactionId, String message) {
        System.out.println(
                "[ERROR] " + now() + " | " + transactionId + " | " + message
        );
        // Haqiqiy loyihada: Sentry yoki Datadog ga xabar ketadi
    }

    public void warn(Long transactionId, String message) {
        System.out.println(
                "[WARN] " + now() + " | " + transactionId + " | " + message
        );
    }

    private String now() {
        return LocalDateTime.now().format(dateFormatter);
    }
}
