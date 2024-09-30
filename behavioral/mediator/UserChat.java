package behavioral.mediator;

public class UserChat extends User {

    public UserChat(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " recebeu: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " enviando mensagem: " + message);
 
        mediator.sendMessage(message, this);
    }
    
}
