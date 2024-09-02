package creatinonal.factorymethod;

public class NotificationService {
    public static void main(String[] args) {

        NotificationFactory emailFactory = new EmailNotificationFactory();
        INotification emailNotification = emailFactory.createNotification();

        NotificationFactory smsFactory = new SMSNotificationFactory();
        INotification smsNotification = smsFactory.createNotification();

        NotificationFactory pushFactory = new PushNotificationFactory();
        INotification pushNotification = pushFactory.createNotification();

        emailNotification.notifyUser();
        smsNotification.notifyUser();
        pushNotification.notifyUser();
    }
    
}
