package notification;

import channel.Channel;
import model.NotificationData;

public class TranzactionNotification extends Notification{

    public TranzactionNotification(Channel channel) {
        super(channel);
    }

    @Override
    public void send(String from, String to, Object data) {


        NotificationData d = (NotificationData) data;

        String sarlavha = "Buyurtmangiz qabul qilindi";
        String matn = String.format(
                "Buyurtma #%s | %s | %,.0f so'm | Holat: %s",
                d.getId(), d.getMahsulot(), d.getSumma(), d.getHolat()
        );

        System.out.println("\n[" + channel.getChannelName()
                + " | BUYURTMA] Yuborilmoqda...");
        channel.send(from, sarlavha, matn);
    }
}
