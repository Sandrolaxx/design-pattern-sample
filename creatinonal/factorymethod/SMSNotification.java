package creatinonal.factorymethod;

public class SMSNotification implements INotification {
    
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por SMS💬");
    }
    
}
