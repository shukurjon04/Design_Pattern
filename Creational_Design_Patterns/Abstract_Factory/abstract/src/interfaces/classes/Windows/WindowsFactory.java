package interfaces.classes.Windows;

import interfaces.Button;
import interfaces.Cursor;
import interfaces.Factory;

public class WindowsFactory implements Factory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Cursor createCursor() {
       return new WindowsCursor();
    }
}
