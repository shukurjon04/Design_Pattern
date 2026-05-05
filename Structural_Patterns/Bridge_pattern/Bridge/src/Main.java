import channel.Channel;
import channel.EmailChannel;
import channel.SmsChannel;
import model.NotificationData;
import notification.Notification;
import notification.OrderNotification;
import notification.TranzactionNotification;

public class Main {
    public static void main(String[] args) {
        NotificationData buyurtma = new NotificationData(
                "ORD-001", "iPhone 15 Pro", 13_999_000, "TASDIQLANDI"
        );

        NotificationData tolov = new NotificationData(
                "TXN-001", "iPhone 15 Pro", 13_999_000, "MUVAFFAQIYATLI"
        );

        Channel sms = new SmsChannel();
        Channel email = new EmailChannel();

        Notification n = new OrderNotification(sms);
        n.send("Shukurjon","Jasur",buyurtma);

        n = new TranzactionNotification(email);
        n.send("Boqiyev","Aliyev",tolov);

        n.setChannel(sms);
        n.send("Boqiyev2","Aliyev",tolov);
    }
}