package notification;

import channel.Channel;

public abstract class Notification {
    protected Channel channel;

    public Notification(Channel channel){
        this.channel=channel;
    }

    public void setChannel(Channel channel){
        this.channel=channel;
    }
    public abstract void send(String from , String to , Object data);
}
