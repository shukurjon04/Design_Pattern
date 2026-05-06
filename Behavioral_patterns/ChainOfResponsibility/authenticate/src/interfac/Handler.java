package interfac;

public abstract class Handler {
    protected Handler handler;

    public Handler setNext(Handler handler){
        this.handler = handler;
        return handler;
    }

    public abstract void handle(String request);
}
