package channel;

public interface Channel {

    void send(String from , String to , Object data);
    String getChannelName();
}
