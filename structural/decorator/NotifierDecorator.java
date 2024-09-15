package structural.decorator;

abstract class NotifierDecorator implements INotifier {

    protected INotifier wrappedNotifier;

    public NotifierDecorator(INotifier INotifier) {
        this.wrappedNotifier = INotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }

}
