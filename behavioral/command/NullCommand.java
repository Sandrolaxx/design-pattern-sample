package behavioral.command;

public class NullCommand implements Command {
    
    @Override
    public void execute() {
        System.out.println("Nenhum comando atribuído.");
    }

    @Override
    public void undo() {
        System.out.println("Nenhum comando para desfazer.");
    }

}
