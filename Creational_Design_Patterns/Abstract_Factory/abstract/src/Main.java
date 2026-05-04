import interfaces.Factory;
import interfaces.classes.Macbook.MacFactory;
import interfaces.classes.Windows.WindowsFactory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Factory factory = switch (s){
            case "Windows" -> new WindowsFactory();
            default -> new MacFactory();
        };

        factory.createButton().button();
    }
}