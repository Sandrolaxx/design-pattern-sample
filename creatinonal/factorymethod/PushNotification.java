package creatinonal.factorymethod;

public class PushNotification implements INotification {

    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação push📲");
    }

}
