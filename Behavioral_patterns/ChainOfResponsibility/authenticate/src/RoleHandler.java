import interfac.Handler;

public class RoleHandler extends Handler {
    @Override
    public void handle(String request) {
        if (request.contains("admin")) {
            System.out.println("Role passed");
            if (handler != null) handler.handle(request);
        } else {
            System.out.println("Role denied");
        }
    }
}
