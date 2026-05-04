import model.PaymentRequest;
import model.PaymentResult;
import service.PaymentService;

public class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        System.out.println("========== TO'LOV 1 ==========");
        PaymentResult r1 = service.tolovQil(
                new PaymentRequest(1L, "9860111122223333", 250_000.0,"UZS","Card")
        );
        System.out.println("Natija: " + r1.getMessage());

        System.out.println("\n========== TO'LOV 2 ==========");
        PaymentResult r2 = service.tolovQil(
                new PaymentRequest(2L, "9860111122223333", 250_000.0,"UZS","Card")
        );
        System.out.println("Natija: " + r2.getMessage());

        System.out.println("\n========== TO'LOV 3 ==========");
        PaymentResult r3 = service.tolovQil(
                new PaymentRequest(3L, "9860111122223333", 250_000.0,"UZS","Card")
        );
        System.out.println("Natija: " + r3.getMessage());
    }
}