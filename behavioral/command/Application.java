package behavioral.command;

public class Application {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(2);

        Light roomLight = new Light();

        Command ligarLuz = new TurnOnLightCommand(roomLight);
        Command desligarLuz = new TurnOffLightCommand(roomLight);

        remoteControl.setCommand(0, ligarLuz);
        remoteControl.setCommand(1, desligarLuz);

        remoteControl.pressButton(0);
        remoteControl.pressButton(1);

        remoteControl.undoLastCommand();
    }
}
