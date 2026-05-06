import interfac.Handler;

public class AuthHandler extends Handler {

    @Override
    public void handle(String request) {
        if (request.contains("auth")) {
            System.out.println("Auth passed");
            if (handler != null) handler.handle(request);
        } else {
            System.out.println("Auth failed");
        }

    }
}
