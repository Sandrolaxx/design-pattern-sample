package behavioral.command;

public class RemoteControl {

    private Command[] buttons;
    
    private Command lastCommand;

    public RemoteControl(int btnQuantity) {
        buttons = new Command[btnQuantity];
        Command nullCommand = new NullCommand();

        for (int i = 0; i < btnQuantity; i++) {
            buttons[i] = nullCommand;
        }
        lastCommand = nullCommand;
    }

    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
    }

    public void pressButton(int slot) {
        buttons[slot].execute();
        lastCommand = buttons[slot];
    }

    public void undoLastCommand() {
        lastCommand.undo();
    }
    
}
