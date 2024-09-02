package creatinonal.factorymethod;

public class PushNotificationFactory extends NotificationFactory {
    
    @Override
    public INotification createNotification() {
        return new PushNotification();
    }

}
