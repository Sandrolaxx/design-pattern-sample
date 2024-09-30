# Mediator

### Cenário de problema💬

Imagine que você está desenvolvendo um sistema de chat para o discord2. Nesse sistema, os usuários podem enviar mensagens uns para os outros em grupos de chat. Cada usuário pode estar em vários grupos, e a comunicação entre os usuários deve ser gerenciada de forma eficiente. 

Se cada usuário fosse responsável por enviar mensagens diretamente para todos os outros usuários do grupo, o código rapidamente se tornaria caótico e difícil de manter, pois cada usuário precisaria conhecer todos os outros. Isso criaria um acoplamento forte entre os componentes, tornando o sistema rígido e complicado de escalar.

---

### Utilização do padrão✅

O padrão **Mediator** é ideal para este cenário porque permite que a comunicação entre os objetos (neste caso, os usuários do chat) seja centralizada em um único objeto intermediário, chamado de mediador. Isso remove o acoplamento direto entre os objetos, tornando o sistema mais flexível e fácil de manter. Os usuários interagem apenas com o mediador, e o mediador é responsável por gerenciar e direcionar a comunicação entre eles.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Mediator em Java para gerenciar a comunicação entre usuários em um sistema de chat:

```java
//1
public interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}
```

1. Interface **ChatMediator** define os métodos que o mediador usará para enviar mensagens e adicionar usuários ao chat.

```java
//1
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receiveMessage(String message);

    public abstract void sendMessage(String message);
}
```

1. Classe abstrata **User** que define as operações básicas de enviar e receber mensagens. Cada usuário está vinculado ao mediador.

```java
//1
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
```

1. Classe **UserChat** implementa a lógica de envio e recebimento de mensagens. Cada usuário envia sua mensagem por meio do mediador.

```java
//1
public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            //2
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}
```

1. Classe **ChatRoom** é o mediador concreto que gerencia a comunicação entre os usuários. Ele envia mensagens para todos os usuários da sala, exceto o remetente.
2. Evita enviar a mensagem de volta para o remetente.

---

### Utilizando Mediator

Aqui está um exemplo de como utilizar o padrão Mediator para gerenciar a comunicação no chat.

```java
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
```

1. Criamos uma instância de **ChatRoom** (o mediador) e adicionamos três usuários (Alice, Bob e Charlie).
2. Cada usuário é adicionado à sala de chat por meio do mediador.
3. Os usuários enviam mensagens que são gerenciadas pelo mediador e entregues aos outros usuários.

---

### Explicação🤓

- **Interface `ChatMediator`:** Define a interface que o mediador usará para gerenciar a comunicação entre os usuários.
- **Classe `ChatRoom`:** Implementa a interface do mediador e gerencia a lógica de envio de mensagens para os usuários.
- **Classe `User`:** Representa um participante do chat que envia e recebe mensagens por meio do mediador.
- **Classe `UserChat`:** Implementa o comportamento específico de envio e recebimento de mensagens no chat.

---

### Quando utilizar?🤔

**Mediator** é útil quando:
- Você deseja centralizar a comunicação entre vários objetos para reduzir o acoplamento entre eles.
- Precisa gerenciar interações complexas entre um grande número de objetos sem que eles dependam diretamente uns dos outros.
- Quer tornar o sistema mais flexível e extensível, permitindo que o mediador administre a lógica de comunicação.

---

### Utilização mundo real🌎

- **Sistemas de chat:** Aplicativos de mensagens e plataformas de colaboração (como Slack, Microsoft Teams) usam o padrão Mediator para gerenciar a comunicação entre os usuários, centralizando as interações em um servidor ou sala de chat.
- **Frameworks de UI:** O padrão Mediator é frequentemente utilizado em interfaces gráficas para gerenciar interações complexas entre diferentes componentes da interface, como diálogos e janelas modais.
- **Sistemas de controle de tráfego aéreo:** Utilizam mediadores para gerenciar a comunicação entre diferentes aeronaves e a torre de controle, evitando que elas se comuniquem diretamente umas com as outras.
- **JMS Java:** A API Java Message Service (JMS) é uma API Java Message Oriented Middleware (MOM) para enviar mensagens entre dois ou mais clientes. A API JMS suporta 2 modelos. Um deles é o modelo de publicação-assinatura. É uma implementação do padrão mediator.

---

O padrão Mediator facilita a comunicação entre múltiplos objetos, promovendo um design mais limpo e organizado.