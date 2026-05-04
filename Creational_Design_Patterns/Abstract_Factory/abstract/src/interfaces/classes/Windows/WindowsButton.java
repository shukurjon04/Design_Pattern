package interfaces.classes.Windows;

import interfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void button() {
        System.out.println("Windows button");
    }
}
