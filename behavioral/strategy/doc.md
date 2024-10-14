# Strategy

### Cenário de problema🚴‍♂️💼

Imagine que você está desenvolvendo um aplicativo de cálculo de rotas para diferentes meios de transporte (bicicleta, carro, busão). Cada tipo de transporte tem uma forma específica de calcular a melhor rota: bicicletas evitam ruas movimentadas, carros preferem rodovias, e o transporte público leva em consideração melhores horários de ônibus.

Se você implementasse esses cálculos diretamente no código da aplicação, acabaria com várias estruturas condicionais difíceis de manter e estender, especialmente se fosse necessário adicionar novos meios de transporte no futuro.

---

### Utilização do padrão✅

O padrão **Strategy** é perfeito para esse cenário, pois permite encapsular as diferentes estratégias de cálculo de rotas em classes separadas. O cliente (a aplicação) pode selecionar qual estratégia de cálculo usar dinamicamente, com base no tipo de transporte escolhido pelo usuário, sem alterar o código da aplicação principal.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão **Strategy**:

```java
//1
public interface IRouteStrategy {
    void calculateRoute(String from, String to);
}
```
1. Define o método que todas as estratégias de cálculo de rota devem implementar

```java
//1
public class BikeRouteStrategy implements IRouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota para bicicleta🚲 de ");
        System.out.print(from + " até " + to + " evitando ruas movimentadas.\n");
    }
}
```
1. Implementação de estratégias - Estratégia para **bicicleta**

##### Estratégia para **carro**:
```java
//1
public class CarRouteStrategy implements IRouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota para carro🚗 de ");
        System.out.print(from + " até " + to + " priorizando rodovias.\n");
    }
}
```
1. Implementação de estratégias - Estratégia para **carro**

```java
//1
public class BusRouteStrategy implements IRouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota do busão🚌 de ");
        System.out.print(from + " até " + to + " levando em consideração horários.\n");
    }
}
```
1. Implementação de estratégias - Estratégia para **busão**

```java
//1
public class RouteContext {
    private IRouteStrategy strategy;

    public void setStrategy(IRouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String from, String to) {
        strategy.calculateRoute(from, to);
    }
}
```
1. Classe **Contexto** - Controla qual estratégia de cálculo de rota será usada

### Utilizando o padrão

```java
public class Application {
    public static void main(String[] args) {
        RouteContext context = new RouteContext();

        //1
        context.setStrategy(new BikeRouteStrategy());
        context.executeStrategy("Avenida Brasil", "Praça Migrante");

        //2
        context.setStrategy(new CarRouteStrategy());
        context.executeStrategy("Avenida Fag", "HubOne");

        //3
        context.setStrategy(new BusRouteStrategy());
        context.executeStrategy("Rua barão do cerro azul, 1250", "Rua xavantes");
    }
}
```
1. Definir a estratégia para bike
2. Definir a estratégia para carro
3. Definir a estratégia para ônibus

---

### Explicação🤓

- **Interface `IRouteStrategy`:** Define o método `calculateRoute()` que será implementado por todas as estratégias de cálculo de rotas.
- **Classes concretas de estratégia (`BikeRouteStrategy`, `CarRouteStrategy`, `BusRouteStrategy`):** Cada uma dessas classes implementa o método `calculateRoute()` de acordo com a lógica específica para aquele tipo de transporte.
- **Classe `RouteContext`:** Controla qual estratégia está em uso e delega a execução para essa estratégia.

---

### Quando utilizar?🤔

Utilize **Strategy** quando:
- Você tem múltiplas formas de executar uma tarefa ou algoritmo e deseja que o cliente escolha qual delas usar.
- Você deseja evitar estruturas condicionais (como `if-else` ou `switch`) no código principal, delegando o comportamento específico para classes de estratégia.

---

### Utilização no mundo real🌎

- **Algoritmos de classificação e pesquisa:** Sistemas que podem usar diferentes algoritmos (como mergesort ou quicksort) podem utilizar o padrão **Strategy** para alternar entre as estratégias de ordenação sem modificar o código cliente.
- **Meios de pagamento em e-commerce:** Plataformas de comércio eletrônico utilizam diferentes estratégias de pagamento, como cartão de crédito, PayPal, e boleto bancário, cada uma com sua própria lógica. O padrão **Strategy** permite selecionar a estratégia de pagamento dinamicamente.