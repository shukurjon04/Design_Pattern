package interfaces.classes.Macbook;

import interfaces.Cursor;

public class MacCursor implements Cursor {
    @Override
    public void cursor() {
        System.out.println("Macbook cursor");
    }
}
