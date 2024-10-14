# State

### Cenário de problema🚦

Imagine que você está desenvolvendo um sistema de semáforo inteligente para uma cidade. O semáforo alterna entre três estados: **Verde**, **Amarelo** e **Vermelho**, e o comportamento de cada estado é diferente, já que o tempo de permanência em cada estado varia e as ações realizadas também dependem do estado.

Implementar o comportamento de mudança de estados diretamente no objeto semáforo com estruturas condicionais pode tornar o código complicado, difícil de manter e aumentar o risco de erros, à medida que o sistema cresce ou se torna mais complexo (como em caso de adicionar novos estados).

---

### Utilização do padrão✅

O padrão **State** é ideal para este cenário, pois permite que cada estado do semáforo seja implementado em uma classe separada, encapsulando o comportamento específico de cada estado. Assim, o objeto semáforo pode alternar entre os estados dinamicamente, delegando o comportamento correspondente a cada classe de estado, sem utilizar condicionais complexas.

---

### Exemplo em Java☕

Abaixo um exemplo da implementação do padrão **State**:

```java
//1
public interface ITrafficLightState {
    void change(TrafficLight light);
    void display();
}
```
1. Define os métodos que cada estado do semáforo deve implementar

```java
//1
public class TrafficLight {
    private ITrafficLightState state;

    public TrafficLight(ITrafficLightState initialState) {
        this.state = initialState;
    }

    public void setState(ITrafficLightState state) {
        this.state = state;
    }

    public void changeState() {
        state.change(this);
    }

    public void displayState() {
        state.display();
    }
}
```
1. Mantém a referência ao estado atual e delega as ações para o estado

```java
//1
public class GreenState implements ITrafficLightState {
    @Override
    public void change(TrafficLight light) {
        light.setState(new YellowState());
    }

    @Override
    public void display() {
        System.out.println("Sinal verde: Avance✅");
    }
}
```
1. Estado sinal verde

```java
//1
public class YellowState implements ITrafficLightState {
    @Override
    public void change(TrafficLight light) {
        light.setState(new RedState());
    }

    @Override
    public void display() {
        System.out.println("Sinal amarelo: Atenção⚠");
    }
}
```
1. Estado sinal amarelo

```java
//1
public class RedState implements ITrafficLightState {
    @Override
    public void change(TrafficLight light) {
        light.setState(new GreenState());
    }

    @Override
    public void display() {
        System.out.println("Sinal vermelho: Pare🔴");
    }
}
```
1. Estado sinal vermelho

### Utilizando o padrão

```java
public class Application {
    public static void main(String[] args) {
        //1
        TrafficLight light = new TrafficLight(new GreenState());

        //2
        for (int i = 0; i < 5; i++) {
            light.displayState();
            light.changeState();
        }
    }
}
```
1. Inicializando o semáforo com o estado verde
2. Ciclando pelos estados do semáforo

---

### Explicação🤓

- **Interface `ITrafficLightState`:** Define o contrato que todos os estados devem seguir. Cada estado implementa dois métodos: `change()` para alternar para o próximo estado e `display()` para exibir o comportamento atual.
- **Classe `TrafficLight`:** Controla o estado atual do semáforo. Ele delega as ações de mudança de estado e exibição do estado para o objeto de estado atual.
- **Classes de estado (`GreenState`, `YellowState`, `RedState`):** Implementam o comportamento específico de cada estado. A mudança de estado ocorre alterando a instância do estado na classe `TrafficLight`.

---

### Quando utilizar?🤔

Utilize **State** quando:
- Um objeto pode ter seu comportamento alterado dinamicamente com base no estado.
- Você deseja eliminar grandes estruturas condicionais (como `if-else` ou `switch`) que controlam o comportamento de um objeto com base em seu estado.

---

### Utilização no mundo real🌎

- **Máquinas de estado em jogos ou automação industrial**: Utilizam o padrão **State** para controlar os diferentes comportamentos de máquinas ou entidades, como um jogador, NPCs em jogos ou sistemas automatizados.
- **Sistemas de autenticação**: Sistemas que mudam de estado entre "logado", "deslogado", "em autenticação", etc., frequentemente usam o padrão **State** para gerenciar essas transições.
