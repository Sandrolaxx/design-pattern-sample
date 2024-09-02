# Factory Method

### Cenário de problema📨

Imagine que você está desenvolvendo um sistema de notificação para uma aplicação que precisa enviar diferentes tipos de notificações para os usuários, como e-mail, SMS e notificações push. Cada tipo de notificação tem uma lógica de envio diferente e requer diferentes configurações.

Se você implementasse a criação dessas notificações diretamente na lógica do sistema, o código se tornaria rígido e difícil de manter, especialmente quando novos tipos de notificações precisarem ser adicionados. Além disso, a criação das instâncias estaria acoplada à lógica da aplicação, o que não é ideal.

---

### Utilização do padrão✅

O padrão **Factory Method** é útil neste cenário, pois ele define uma interface para a criação de objetos em uma superclasse, mas permite que as subclasses decidam qual classe concreta instanciar. Isso desacopla o código que usa as classes dos detalhes de sua criação, tornando o sistema mais flexível e fácil de estender.

---

### Exemplo em Java☕

Aqui está um exemplo de como implementar o padrão Factory Method em Java:

```java
// Interface Notification
public interface INotification {
    //1
    void notifyUser();
}
```

1. Define o contrato (método) que todas as classes concretas devem seguir.

```java
//1
public class EmailNotification implements INotification {
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por e-mail📧");
    }
}

//1
public class SMSNotification implements INotification {
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por SMS💬");
    }
}

//1
public class PushNotification implements INotification {
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação push📲");
    }
}
```

1. Criação da classe concreta, implementação da interface e definindo seu respectivo funcionamento. 


```java
public abstract class NotificationFactory {
    public abstract INotification createNotification();
}
```

1. Classe abstrata NotificationFactory que define o método de criação.

```java
//1
public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public INotification createNotification() {
        return new EmailNotification();
    }
}

//1
public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public INotification createNotification() {
        return new SMSNotification();
    }
}

//1
public class PushNotificationFactory extends NotificationFactory {
    @Override
    public INotification createNotification() {
        return new PushNotification();
    }
}
```

1. Respectiva subclasse concreta para criação de cada implementação disponível.

### Utilizando a Factory

No sistema de notificação:
```java
public class NotificationService {
    public static void main(String[] args) {
        //1
        NotificationFactory emailFactory = new EmailNotificationFactory();
        INotification emailNotification = emailFactory.createNotification();

        //2
        NotificationFactory smsFactory = new SMSNotificationFactory();
        INotification smsNotification = smsFactory.createNotification();

        //3
        NotificationFactory pushFactory = new PushNotificationFactory();
        INotification pushNotification = pushFactory.createNotification();

        //4
        emailNotification.notifyUser();
        smsNotification.notifyUser();
        pushNotification.notifyUser();
        //5
    }
}
```

1. Cria uma factory para e-mail.
2. Cria uma factory para SMS.
3. Cria uma factory para push.
4. Utilizando a implementação concreta definida na subclass.
5. Exemplo acima é simples, porém estaríamos instanciando a classe concreta dinamicamente, com base em interações do usuário, não instanciando todas de uma vez.

---

### Explicação🤓

- **Interface `INotification`:** Define o contrato que todas as notificações devem seguir. Isso garante que cada tipo de notificação implementa o método `notifyUser`.

- **Classes concretas (`EmailNotification`, `SMSNotification`, `PushNotification`):** Implementam a interface `INotification` e contêm a lógica específica para enviar cada tipo de notificação.

- **Classe `NotificationFactory`:** É uma classe abstrata que define o método `createNotification`. Este método é um "factory method" que as subclasses devem implementar para criar instâncias de `INotification`.

- **Subclasses de `NotificationFactory`:** Cada uma das subclasses (`EmailNotificationFactory`, `SMSNotificationFactory`, `PushNotificationFactory`) implementa o método `createNotification` para retornar uma instância do tipo apropriado de notificação.

- **Desacoplamento:** O uso do padrão Factory Method permite que o sistema de notificação seja estendido facilmente. Se um novo tipo de notificação precisar ser adicionado, basta criar uma nova classe concreta que implementa `INotification` e uma nova factory correspondente, sem modificar o código existente.

---

### Quando utilizar?🤔

Factory Method é útil quando:
- Você deseja permitir que subclasses decidam qual classe concreta instanciar.
- Você precisa de flexibilidade para adicionar novos tipos de objetos sem modificar o código existente.
- Você deseja evitar acoplamento rígido entre a lógica de aplicação e a lógica de criação de objetos.

Esse padrão é frequentemente utilizado em frameworks onde as bibliotecas precisam criar objetos, mas a aplicação deve decidir a classe concreta a ser usada. Por exemplo, em bibliotecas GUI (interfaces gráficas de usuário), onde o framework pode precisar criar janelas ou botões, mas a aplicação decide a aparência e o comportamento exatos desses componentes.