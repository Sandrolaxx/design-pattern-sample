package structural.decorator;

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(INotifier iNotifier) {
        super(iNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);

        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Enviando SMS📲: " + message);
    }

}
