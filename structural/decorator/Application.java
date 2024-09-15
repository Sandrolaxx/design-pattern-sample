package structural.decorator;

public class Application {

    public static void main(String[] args) {
        INotifier emailNotifier = new EmailNotifier();

        INotifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        INotifier logAndSmsNotifier = new LogNotifierDecorator(smsNotifier);

        logAndSmsNotifier.send("Olá, esse é um exemplo de notificação!");
    }
}