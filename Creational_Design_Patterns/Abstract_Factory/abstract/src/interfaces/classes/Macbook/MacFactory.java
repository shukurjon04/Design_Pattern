package interfaces.classes.Macbook;

import interfaces.Button;
import interfaces.Cursor;
import interfaces.Factory;

public class MacFactory implements Factory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Cursor createCursor() {
       return new MacCursor();
    }


}
