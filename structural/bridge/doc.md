# Bridge🌉

### Cenário do problema📺

Imagine que você está desenvolvendo um sistema que controla dispositivos eletrônicos como TVs e rádios. Você precisa criar diferentes tipos de controles remotos (por exemplo, controles básicos e avançados) para esses dispositivos. Uma abordagem simples seria criar classes específicas para cada tipo de controle e dispositivo (por exemplo, `ControleRemotoTV`, `ControleRemotoRadio`), mas isso levaria a uma explosão de subclasses conforme novos dispositivos e novos tipos de controles surgem.

---

### Utilização do padrão✅

O padrão **Bridge** permite separar a abstração (o controle remoto) da implementação (os dispositivos eletrônicos), possibilitando a criação de controles e dispositivos de forma independente, sem a necessidade de criar várias subclasses.

---

### Exemplo em Java☕

```java
//1
interface IDevice {
    void powerOn();
    void powerOff();
    void setVolume(int percent);
    boolean isPoweredOn();
}
```
1. Interface que define as operações dos dispositivos


```java
//1
class TV implements IDevice {
    private boolean on = false;
    private int volume = 50;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("TV ligada.📺");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("TV desligada.⛔📺");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Volume da TV ajustado para: " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
}
```

1. Implementação concreta de um dispositivo: TV

```java
//1
class Radio implements IDevice {
    private boolean on = false;
    private int volume = 50;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("Rádio ligado.📻");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("Rádio desligado.⛔📻");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Volume do rádio ajustado para: " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
}
```
1. Implementação concreta de um dispositivo: Rádio

```java
//1
class RemoteControl {
    protected IDevice device;

    public RemoteControl(IDevice device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isPoweredOn()) {
            device.powerOff();

            return;
        }

        device.powerOn();
    }

    public void volumeUp() {
        System.out.println("Aumentando o volume...");
    }

    public void volumeDown() {
        System.out.println("Diminuindo o volume...");
    }
}
```
1. Abstração do controle remoto simples

```java
//1
class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(IDevice device) {
        super(device);
    }

    public void mute() {
        System.out.println("Silenciando o dispositivo...🔇");
        device.setVolume(0);
    }
}
```
1. Controle remoto avançado, que adiciona funcionalidades

### Utilizando Bridge

```java
public class Application {
    public static void main(String[] args) {
        //1
        IDevice tv = new TV();
        RemoteControl tvRemote = new RemoteControl(tv);
        tvRemote.togglePower();
        tvRemote.volumeUp();

        //2
        IDevice radio = new Radio();
        AdvancedRemoteControl radioRemote = new AdvancedRemoteControl(radio);
        radioRemote.togglePower();
        radioRemote.mute();
    }
}
```
1. Controle básico para TV
2. Controle avançado para rádio

---

### Explicação🤓

- **Separação de abstração e implementação**: O **Bridge** permite separar a lógica de controle (como o controle remoto) da implementação específica de dispositivos (TV, rádio). Isso facilita a manutenção e extensão do sistema, permitindo adicionar novos controles ou dispositivos sem criar subclasses específicas para cada combinação.
  
- **Facilidade de extensão**: Novos dispositivos ou tipos de controles podem ser adicionados sem alterar o código existente. Por exemplo, se surgir um novo dispositivo (uma **caixa de som**) ou um novo controle (**Controle Inteligente**), eles podem ser adicionados independentemente.

- **Redução de subclasses**: Sem o padrão **Bridge**, seria necessário criar subclasses para cada combinação de controle e dispositivo (por exemplo, `ControleRemotoTV`, `ControleRemotoRadio`, etc.). O **Bridge** evita essa explosão de subclasses ao separar as duas hierarquias.

---

### Quando utilizar?🤔

**Bridge** é útil quando:
- Você precisa evitar a criação de muitas subclasses ao combinar abstrações e implementações.
- Você deseja que a abstração e a implementação possam variar de forma independente.
- Você deseja aumentar a flexibilidade de um sistema que deve ser expansível no futuro (novos controles, novos dispositivos).

---

### Utilização mundo real🌎

- **JDBC**: Interface genérica usada pelo desenvolvedor (como Connection, Statement, ResultSet) é a abstração. As diferentes implementações dos drivers de banco de dados (como MySQL, PostgreSQL, Oracle) são as implementações concretas. O JDBC permite que o código de acesso ao banco de dados funcione de maneira uniforme, independentemente do banco subjacente.
- **AWT (Abstract Window Toolkit)**: Separa a interface gráfica (`Component`, `Graphics`) da implementação concreta que renderiza os componentes na tela. Isso permite que os mesmos componentes gráficos sejam renderizados de maneira diferente em diferentes plataformas (Windows, macOS, Linux) sem modificar a lógica dos componentes.

---

Em resumo, recomendado para sistemas que precisam lidar com várias abstrações e implementações que podem variar independentemente umas das outras.