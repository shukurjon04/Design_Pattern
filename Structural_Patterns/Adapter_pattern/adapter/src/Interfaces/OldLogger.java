package Interfaces;

public class OldLogger {
    public void log(String level, String message) {
        System.out.println("[" + level.toUpperCase() + "] " + message);
    }
}
