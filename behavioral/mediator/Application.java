package behavioral.mediator;

public class Application {
    public static void main(String[] args) {
        //1
        ChatMediator salaDeChat = new ChatRoom();

        User user1 = new UserChat(salaDeChat, "Elon ma");
        User user2 = new UserChat(salaDeChat, "Roberto da Silva");
        User user3 = new UserChat(salaDeChat, "Flávio josefo");

        //2
        salaDeChat.addUser(user1);
        salaDeChat.addUser(user2);
        salaDeChat.addUser(user3);

        //3
        user1.sendMessage("Olá, pessoal!");
        user2.sendMessage("Oi, Elon!");
    }
}
