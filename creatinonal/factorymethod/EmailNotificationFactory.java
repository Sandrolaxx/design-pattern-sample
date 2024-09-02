package creatinonal.factorymethod;

public class EmailNotificationFactory extends NotificationFactory {
    
    @Override
    public INotification createNotification() {
        return new EmailNotification();
    }

}
