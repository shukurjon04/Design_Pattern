import Interfaces.NewLogger;

public class OrderService {

    private final NewLogger logger;

    public OrderService(NewLogger logger) {
        this.logger = logger;

    }

    public void placeOrder(String item){
        logger.info("Buyurtma qabul qilindi: " + item);

        logger.info("Buyurtma tasdiqlandi: " + item);
    }
}
