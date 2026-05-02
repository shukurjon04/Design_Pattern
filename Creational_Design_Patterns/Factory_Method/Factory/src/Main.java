import model.PaymentRequest;
import model.PaymentResult;
import service.PaymentService;

public class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        // Humo karta bilan to'lov
        PaymentRequest humoTolov = new PaymentRequest(
                "TXN-001",
                "9860123456789012",   // 9860 — Humo
                250000.00,
                "UZS",
                "card"
        );

        // Uzcard bilan to'lov
        PaymentRequest uzcardTolov = new PaymentRequest(
                "TXN-002",
                "8600987654321098",   // 8600 — Uzcard
                180000.00,
                "UZS",
                "card"
        );

        service.tolovQil(humoTolov);
        System.out.println("----------");
        service.tolovQil(uzcardTolov);
    }
}