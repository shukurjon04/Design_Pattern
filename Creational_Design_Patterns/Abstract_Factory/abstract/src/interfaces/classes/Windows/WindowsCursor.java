package interfaces.classes.Windows;

import interfaces.Cursor;

public class WindowsCursor implements Cursor {
    @Override
    public void cursor() {
        System.out.println("windows cursor");
    }
}
