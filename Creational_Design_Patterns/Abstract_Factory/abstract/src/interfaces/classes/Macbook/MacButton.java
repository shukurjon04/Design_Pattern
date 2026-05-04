package interfaces.classes.Macbook;

import interfaces.Button;

public class MacButton implements Button {
    @Override
    public void button() {
        System.out.println("Macbook button");
    }
}
