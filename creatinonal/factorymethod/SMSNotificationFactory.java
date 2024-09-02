package creatinonal.factorymethod;

public class SMSNotificationFactory extends NotificationFactory {

    @Override
    public INotification createNotification() {
        return new SMSNotification();
    }

}
