package creatinonal.factorymethod;

public class EmailNotification implements INotification {

    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por e-mail📧");
    }

}
