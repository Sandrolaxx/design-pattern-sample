package structural.decorator;

class LogNotifierDecorator extends NotifierDecorator {

    public LogNotifierDecorator(INotifier INotifier) {
        super(INotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);

        logNotification(message);
    }

    private void logNotification(String message) {
        System.out.println("Registrando notificação: " + message);
    }

}
