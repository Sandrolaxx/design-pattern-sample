package structural.decorator;

class EmailNotifier implements INotifier {

    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }

}
