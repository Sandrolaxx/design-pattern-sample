# Observer

### Cenário de problema🌤️🌧️

Imagine que você está desenvolvendo um aplicativo de previsão do tempo. A cada mudança nas condições climáticas (como temperatura, umidade ou pressão), vários componentes da interface do usuário, como gráficos, alertas de tempo e relatórios detalhados, precisam ser atualizados automaticamente com as novas informações.

Se cada componente precisasse verificar manualmente a mudança no estado do clima, isso levaria a um código complexo e altamente acoplado. Cada componente precisaria conhecer o estado da classe responsável pelos dados de clima e, ao mesmo tempo, precisaria verificar constantemente se houve alterações.

---

### Utilização do padrão✅

O padrão **Observer** é ideal para esse cenário porque ele permite que todos os componentes da interface do usuário (observadores) sejam automaticamente notificados e atualizados sempre que o estado do clima (sujeito) mudar. Assim, o clima centraliza as informações, e cada componente se registra como observador.

---

### Exemplo em Java☕

Abaixo um exemplo da implementação do padrão Observer:

```java
//1
public interface IObserver {
    void update(float temperature, float humidity, float pressure);
}
```
1. Interface IObserver define o contrato para os observadores que serão notificados sobre mudanças no sujeito (clima)

```java
//1
public interface ISubject {
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}
```
1. Interface ISubject define o contrato para o sujeito que gerencia a lista de observadores e notifica-os sobre mudanças

```java
import java.util.ArrayList;
import java.util.List;

//1
public class WeatherData implements ISubject {
    private List<IObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(IObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        notifyObservers();
    }
}
```
1. Implementação do sujeito (Clima), mantém os dados do clima e notifica os observadores sempre que houver uma mudança

```java
//1
public class GraphDisplay implements IObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Atualizando gráfico: Temp: " + temperature + " Humidade: " + humidity + " Pressão: " + pressure);
    }
}
```
1. Primeiro observador, exibir os dados em um gráfico

```java
//1
public class WeatherAlertDisplay implements IObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        if (temperature > 35) {
            System.out.println("Alerta de calor extremo! Temp: " + temperature);
        } else if (pressure < 1000) {
            System.out.println("Alerta de tempestade! Pressão: " + pressure);
        }
    }
}
```
1. Segundo observador, alerta de temperatura

### Utilizando Observer

Abaixo um exemplo de utilização do padrão no sistema de previsão do tempo:

```java
public class Application {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        IObserver graphDisplay = new GraphDisplay();
        IObserver weatherAlertDisplay = new WeatherAlertDisplay();

        weatherData.registerObserver(graphDisplay);
        weatherData.registerObserver(weatherAlertDisplay);

        //1
        weatherData.setMeasurements(36.0f, 65.0f, 1010.0f);//2
        weatherData.setMeasurements(25.0f, 80.0f, 990.0f); //3
    }
}
```
1. Simulando novas leituras de clima
2. Alerta de calor
3. Alerta de tempestade

---

### Explicação🤓

- **Interface `IObserver`:** Define o método `update()` que é chamado pelo sujeito para notificar as mudanças.
- **Interface `ISubject`:** Gerencia os observadores e os notifica.
- **Classe `WeatherData`:** Implementa a lógica de notificação e atualiza todos os observadores sempre que as condições climáticas mudam.
- **Classes `GraphDisplay` e `WeatherAlertDisplay`:** Implementam a interface `IObserver` e respondem de maneiras diferentes às mudanças nos dados de clima.

---

### Quando utilizar?🤔

Utilize **Observer** quando:
- Um objeto precisa notificar múltiplos outros objetos sobre mudanças em seu estado.
- Você deseja um sistema desacoplado, onde os objetos não precisam saber muito sobre os outros, além do fato de que precisam ser notificados.

---

### Utilização mundo real🌎

- **Interface de Usuário (UI)**: Em frameworks de UI, o padrão **Observer** é utilizado para atualizar automaticamente a interface gráfica quando o modelo de dados é alterado.
- **Eventos em Sistemas de Notificações**: Quando algo muda no estado de um sistema, como em aplicações de e-commerce ou redes sociais, o padrão **Observer** pode ser utilizado para notificar componentes como notificações push ou atualizações de feed.

---

### Qual a diferença de Observer para Mediator?

As semelhanças entre os padrões **Observer** e **Mediator** podem levar à confusão, mas eles têm objetivos, estruturas e comportamentos distintos. Aqui está uma análise mais aprofundada que explora as diferenças fundamentais entre os dois padrões.

#### <u>Observer</u>

- **Objetivo**:
   - O padrão Observer visa notificar múltiplos objetos (observadores) sobre mudanças de estado em um único objeto (sujeito). É uma implementação do padrão de publicação/assinatura(pub/sub), onde os observadores se inscrevem para receber atualizações.

- **Estrutura**:
   - **Sujeito (Subject)**: Mantém uma lista de observadores e notifica-os quando seu estado muda.
   - **Observadores (Observers)**: Implementam uma interface que define como devem receber notificações do sujeito.
   - **Relação**: O sujeito e os observadores estão diretamente conectados. Quando o estado do sujeito muda, ele invoca métodos nos observadores. 

- **Acoplamento**:
   - O padrão Observer promove um acoplamento mais solto entre o sujeito e os observadores, permitindo que novos observadores sejam adicionados ou removidos sem alterar a lógica do sujeito. No entanto, o sujeito precisa conhecer os observadores, o que pode criar um acoplamento em algum nível.

#### <u>Mediator</u>

- **Objetivo**:
   - O padrão Mediator visa reduzir a complexidade das interações entre múltiplos objetos, centralizando a comunicação em um único objeto mediador. Isso evita que os objetos precisem saber uns sobre os outros, o que reduz o acoplamento e melhora a manutenibilidade.

- **Estrutura**:
   - **Mediator**: Um objeto que encapsula as interações entre os objetos envolvidos. Ele coordena as comunicações entre eles.
   - **Colaboradores (Colleagues)**: Objetos que interagem entre si apenas através do mediador, enviando mensagens ao mediador e recebendo respostas ou notificações dele.
   - **Relação**: Os colaboradores não conhecem uns aos outros; todos se comunicam com o mediador, que coordena a interação.

- **Acoplamento**:
   - O padrão Mediator elimina o acoplamento direto entre os colaboradores, permitindo que novos colaboradores sejam adicionados ou existentes sejam modificados sem afetar o restante do sistema. O mediador controla a lógica de comunicação, reduzindo a dependência entre os colaboradores.

#### Comparação Detalhada

| Aspecto                   | Observer                                     | Mediator                                     |
|---------------------------|----------------------------------------------|----------------------------------------------|
| **Propósito**             | Notificar mudanças de estado a múltiplos objetos. | Facilitar a comunicação entre múltiplos objetos sem acoplamento direto. |
| **Relação**               | Um-para-muitos (sujeito para observadores). | Muitos-para-um (objetos comunicam-se através de um mediador). |
| **Conhecimento**          | O sujeito conhece seus observadores e os notifica diretamente. | Colaboradores não conhecem uns aos outros; todos se comunicam através do mediador. |
| **Acoplamento**           | O acoplamento é mais solto, mas o sujeito deve conhecer os observadores. | O acoplamento é eliminado; os colaboradores dependem do mediador para comunicação. |
| **Complexidade**          | Facilita a implementação de sistemas de eventos, mas pode criar complexidade quando muitos observadores estão envolvidos. | Reduz a complexidade da comunicação entre múltiplos objetos, centralizando a lógica no mediador. |
| **Manutenção**            | Novos observadores podem ser adicionados, mas isso pode exigir mudanças no sujeito. | Novos colaboradores podem ser adicionados sem alterar o mediador ou os colaboradores existentes. |
| **Responsabilidade**      | O sujeito é responsável por manter os observadores atualizados. | O mediador é responsável por controlar a comunicação e a lógica entre os colaboradores. |

Em resumo, enquanto o padrão **Observer** se concentra na notificação de mudanças de estado a vários objetos, o padrão **Mediator** busca simplificar e centralizar a comunicação entre objetos, evitando dependências diretas. Essa distinção é fundamental para escolher o padrão certo com base nas necessidades do sistema em desenvolvimento.