# Decorator

### Cenário de problema

Imagine que você tem um sistema de **notificações**. A notificação básica envia mensagens via e-mail. No entanto, você deseja adicionar a capacidade de enviar mensagens via SMS e registrar as notificações em um log. Usar o **Decorator** permite adicionar essas funcionalidades de forma flexível e modular.

Modificar diretamente a classe base que possui a funcionalidade pode ser uma má ideia, especialmente se várias funcionalidades forem opcionais e não aplicáveis em todas as situações.

---

### Utilização do padrão✅

**Decorator** resolve esse problema, permitindo que comportamentos adicionais sejam anexados dinamicamente a um objeto existente sem alterar sua estrutura original.

---

### Exemplo em Java☕

```java
//1
interface INotifier {
    void send(String message);
}
```
1. Interface comum para o componente e o decorador

```java
//1
class EmailNotifier implements INotifier {
    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}
```
1. Componente concreto que implementa o comportamento básico

```java
//1
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
```
1. Classe Decorator que adiciona funcionalidades ao INotifier

```java
//1
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(INotifier INotifier) {
        super(INotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
```
1. Decorador concreto que adiciona a funcionalidade de enviar SMS

```java
//1
class LogNotifierDecorator extends NotifierDecorator {
    public LogNotifierDecorator(INotifier INotifier) {
        super(INotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        logNotification(message);
    }

    private void logNotification(String message) {
        System.out.println("Registrando notificação: " + message);
    }
}
```
1. Decorador concreto que adiciona a funcionalidade de logar notificações

Aplicação do Decorator

```java
public class Application {
    public static void main(String[] args) {
        //1
        INotifier emailNotifier = new EmailNotifier();

        //2
        INotifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        //3
        INotifier logAndSmsNotifier = new LogNotifierDecorator(smsNotifier);

        //4
        logAndSmsNotifier.send("Olá, esse é um exemplo de notificação!");
    }
}
```
1. Notificador básico
2. Adiciona a funcionalidade de SMS
3. Adiciona a funcionalidade de log, além do SMS
4. Envia a notificação

---

### Explicação🤓

- A interface `INotifier` define o método `send()`, que todas as classes concretas e decoradores irão implementar.
- A classe `EmailNotifier` é o **componente concreto**, implementando o envio de notificações via e-mail.
- As classes `SMSNotifierDecorator` e `LogNotifierDecorator` são **decoradores concretos** que adicionam funcionalidades de envio de SMS e registro de logs, respectivamente. Elas utilizam a composição para adicionar novos comportamentos de forma incremental.

---

### Quando utilizar?🤔

**Decorator** é útil quando:
- Quando você deseja adicionar responsabilidades ou funcionalidades adicionais a objetos individuais de maneira dinâmica.
- Quando a extensão por herança não é viável ou cria uma complexidade excessiva.
- Quando diferentes combinações de funcionalidades devem ser aplicadas a objetos, e criar subclasses para todas as combinações seria impraticável.

Em resumo, é ideal em cenários onde a funcionalidade deve ser incrementada de forma flexível e dinâmica, como em sistemas de notificação, streams de I/O ou interfaces gráficas.