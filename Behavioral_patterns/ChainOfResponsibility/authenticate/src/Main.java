import interfac.Handler;

public class Main {
    public static void main(String[] args) {
        Handler auth = new AuthHandler();
        Handler role = new RoleHandler();


        auth.setNext(role);

        auth.handle("auth admin request");
    }
}