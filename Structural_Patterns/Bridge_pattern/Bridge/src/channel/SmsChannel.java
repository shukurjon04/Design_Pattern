package channel;

public class SmsChannel implements Channel {
    @Override
    public void send(String from, String to, Object data) {
        System.out.println("[SMS] -> " + to);
        System.out.println("        " + data.toString());
    }

    @Override
    public String getChannelName() {
        return "SMS";
    }
}
