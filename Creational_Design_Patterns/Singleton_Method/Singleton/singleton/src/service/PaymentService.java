package service;

import model.PaymentRequest;
import model.PaymentResult;
import singleton.CacheManager;
import singleton.ClickConfig;
import singleton.DatabaseConnection;
import singleton.PaymentLogger;

public class PaymentService {

    public PaymentResult tolovQil(PaymentRequest request) {

        // Singletonlar — har biri bitta nusxa
        PaymentLogger logger = PaymentLogger.getInstance();
        ClickConfig config = ClickConfig.getInstance();
        DatabaseConnection db     = DatabaseConnection.getInstance();
        CacheManager cache  = CacheManager.getInstance();

        logger.info(request.getTransactionId(), "To'lov boshlandi");

        // 1. Miqdorni tekshirish
        if (request.getAmount() < config.getMinPaymentAmount()) {
            logger.error(
                    request.getTransactionId(),
                    "Summa juda kam: " + request.getAmount()
            );
            return new PaymentResult(
                    false,
                    request.getTransactionId(),
                    "Minimal summa: " + config.getMinPaymentAmount(),
                    "MIN_AMOUNT_ERROR"
            );
        }

        if (request.getAmount() > config.getMaxPaymentAmount()) {
            logger.error(
                    request.getTransactionId(),
                    "Summa juda ko'p: " + request.getAmount()
            );
            return new PaymentResult(
                    false,
                    request.getTransactionId(),
                    "Maksimal summa: " + config.getMaxPaymentAmount(),
                    "MAX_AMOUNT_ERROR"
            );
        }

        // 2. Tranzaksiya takrorlanishini tekshirish
        if (db.existsTransaction(request.getTransactionId())) {
            logger.warn(
                    request.getTransactionId(),
                    "Bu tranzaksiya allaqachon mavjud"
            );
            return new PaymentResult(
                    false,
                    request.getTransactionId(),
                    "Tranzaksiya takrorlandi",
                    "DUPLICATE_TRANSACTION"
            );
        }

        // 3. Cache dan tekshirish — tezkor
        String cacheKey = "card_limit_" + request.getCardNumber();
        if (cache.contains(cacheKey)) {
            logger.info(request.getTransactionId(), "Cache dan olindi");
        } else {
            cache.put(cacheKey, request.getAmount());
        }

        // 4. To'lovni amalga oshirish
        logger.info(
                request.getTransactionId(),
                "API ga so'rov: " + config.getApiUrl()
        );

        // Haqiqiy loyihada bu yerda HTTP request ketadi
        boolean success = true;

        // 5. Bazaga saqlash
        db.saveTransaction(request.getCardNumber(), request.getAmount(),"o");

        if (success) {
            logger.info(request.getTransactionId(), "To'lov muvaffaqiyatli");
            return new PaymentResult(
                    true,
                    request.getTransactionId(),
                    "To'lov tasdiqlandi",
                    null
            );
        } else {
            logger.error(request.getTransactionId(), "To'lov amalga oshmadi");
            return new PaymentResult(
                    false,
                    request.getTransactionId(),
                    "To'lov amalga oshmadi",
                    "PAYMENT_FAILED"
            );
        }
    }
}
