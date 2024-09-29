# Command

### Cenário de problema🎛

Imagine que você está desenvolvendo um sistema de automação residencial que permite aos usuários controlar dispositivos, como lâmpadas, cortinas e sistemas de som, por meio de comandos emitidos através de um controle remoto. 

O sistema precisa ser flexível o suficiente para permitir que novos dispositivos sejam adicionados no futuro, sem que o controle remoto precise ser alterado. Além disso, os usuários querem ter a capacidade de desfazer uma ação, como desligar a lâmpada depois de tê-la ligado acidentalmente.

Implementar essa lógica diretamente no controle remoto levaria a um código rígido e difícil de manter, pois para cada novo dispositivo ou funcionalidade seria necessário modificar o código do controle. 

---

### Utilização do padrão✅

O padrão **Command** é ideal para este cenário porque encapsula as ações (comandos) em objetos, permitindo que o controle remoto emita comandos sem precisar conhecer os detalhes da implementação dos dispositivos. Isso promove a flexibilidade e a extensibilidade do sistema. Também permite a implementação da funcionalidade de desfazer comandos, já que cada comando pode armazenar seu estado anterior.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Command em Java para o cenário de automação residencial:

```java
//1
public interface Command {
    void execute();

    void undo();
}
```

1. Interface `Command` que define os métodos `execute` (para executar a ação) e `undo` (para desfazer a ação).

```java
//1
public class Light {
    public void on() {
        System.out.println("A luz está ligada.");
    }

    public void off() {
        System.out.println("A luz está desligada.");
    }
}
```

1. A classe que representa o dispositivo **Light**(Luz), com métodos para ligar e desligar.

```java
//1
public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
```

1. Implementação de um comando concreto que encapsula a ação de ligar a luz e também permite desfazer (desligar).

```java
//1
public class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
```

1. Comando para desligar a luz, com a capacidade de desfazer (ligar a luz novamente).

---

### Utilizando Command

Agora vamos configurar o controle remoto para emitir comandos sem conhecer os detalhes dos dispositivos:

```java
//1
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
```

1. Um comando nulo que evita comportamentos inesperados ao pressionar um botão sem comando atribuído.

```java
//1
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
```

1. **RemoteControl** é o invocador que armazena os comandos nos seus botões. Ele também mantém um registro do último comando para permitir o "desfazer".

---

### Configurando e executando os comandos

Aqui está um exemplo de como utilizar o padrão Command para controlar uma luz com o controle remoto:

```java
public class Application {
    public static void main(String[] args) {
        //1
        RemoteControl remoteControl = new RemoteControl(2);

        //2
        Light roomLight = new Light();

        //3
        Command ligarLuz = new TurnOnLightCommand(roomLight);
        Command desligarLuz = new TurnOffLightCommand(roomLight);

        //4
        remoteControl.setCommand(0, ligarLuz);
        remoteControl.setCommand(1, desligarLuz);

        //5
        remoteControl.pressButton(0);
        remoteControl.pressButton(1);

        //6
        remoteControl.undoLastCommand();
    }
}
```

1. Criamos o controle remoto com dois botões.
2. Criamos o dispositivo **Light**(Luz).
3. Criamos os comandos concretos para ligar e desligar a luz.
4. Associamos os comandos aos botões do controle remoto.
5. Executamos os comandos pressionando os botões.
6. Desfazemos o último comando (desfaz o desligamento, ligando a luz novamente).

---

### Explicação🤓

- **Interface `Command`:** Define o contrato para todos os comandos com os métodos `execute` e `undo`.
- **Classes concretas (`TurnOnLightCommand`, `TurnOffLightCommand`):** Implementam o comando para ligar e desligar a luz, encapsulando a lógica dentro de objetos de comando.
- **RemoteControl:** Atua como o invocador que armazena e executa os comandos. Ele não conhece os detalhes dos dispositivos, apenas invoca os métodos `execute` dos comandos.
- **Comando Nulo (`NullCommand`):** Um padrão para evitar exceções quando não há comandos atribuídos a determinados botões.

---

### Quando utilizar?🤔

**Command** é útil quando:
- Você deseja encapsular uma solicitação como um objeto, permitindo parametrizar métodos com diferentes comandos, enfileirar solicitações ou implementar operações reversíveis (como desfazer).
- Você precisa que as operações sejam tratadas de maneira uniforme, como em sistemas de controle remoto ou menus de interfaces gráficas.
- Deseja adicionar a funcionalidade de desfazer/refazer em um sistema.

---

### Utilização mundo real🌎

- **Interfaces gráficas de usuário (GUIs):** Usam o padrão Command para mapear ações de botões em operações de negócios, permitindo o suporte a por exemplo, desfazer/refazer.
- **Sistemas de transações:** Onde comandos podem ser armazenados, reexecutados ou revertidos conforme necessário, como em bancos de dados que suportam operações de undo e redo.