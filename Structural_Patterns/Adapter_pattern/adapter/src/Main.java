import Adapter.ConvertLogger;
import Interfaces.NewLogger;
import Interfaces.OldLogger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OldLogger oldLogger = new OldLogger();
        NewLogger adapter = new ConvertLogger(oldLogger);
        OrderService service = new OrderService(adapter);
        service.placeOrder("Java");
    }
}