# Facade

### Cenário do problema📽️

Imagine que estamos desenvolvendo um **sistema de gerenciamento de cinema**. O processo de reserva de um ingresso envolve múltiplos passos, como escolher o filme, selecionar assentos, fazer o pagamento e enviar um e-mail de confirmação. Caso o cliente tenha de lidar com cada uma dessas operações, iremos aumentar a complexidade do código e abrir margem para erros.

---

### Utilização do padrão✅

Sem o uso do padrão **Facade**, o cliente teria o problema de lidar com as operações diretamente. Para simplificar, podemos criar uma **classe Facade** que encapsula esses passos e oferece uma interface simples para o cliente interagir.

---

### Exemplo em Java☕

Aqui estão as classes que representam o subsistema de gerenciamento do cinema.

```java
//1
class MovieService {
    public void chooseMovie(String movie) {
        System.out.println("Filme escolhido📽️: " + movie);
    }
}
```
1. Classe para gerenciar os filmes disponíveis

```java
//1
class SeatService {
    public void selectSeat(int seatNumber) {
        System.out.println("Assento selecionado🎟️: " + seatNumber);
    }
}
```
1. Classe para gerenciar a seleção de assentos

```java
//1
class PaymentService {
    public void makePayment(String paymentMethod) {
        System.out.println("Pagamento realizado com💵: " + paymentMethod);
    }
}
```
1. Classe para gerenciar o pagamento

```java
//1
class ConfirmationService {
    public void sendConfirmation(String movie, int seatNumber) {
        System.out.println("E-mail de confirmação do filme " + movie + " no assento " + seatNumber);
    }
}
```
1. Classe para envio do e-mail de confirmação

A classe **CinemaFacade** irá encapsular a complexidade dos subsistemas e fornecer uma interface simples para o cliente.

```java
//1
class CinemaFacade {
    private MovieService movieService;
    private SeatService seatService;
    private PaymentService paymentService;
    private ConfirmationService confirmationService;

    public CinemaFacade() {
        movieService = new MovieService();
        seatService = new SeatService();
        paymentService = new PaymentService();
        confirmationService = new ConfirmationService();
    }

    //2
    public void bookTicket(String movie, int seatNumber, String paymentMethod) {
        movieService.chooseMovie(movie);
        seatService.selectSeat(seatNumber);
        paymentService.makePayment(paymentMethod);
        confirmationService.sendConfirmation(movie, seatNumber);

        System.out.println("Reserva de ingresso concluída com sucesso!");
    }
}
```
1. Classe Facade
2. Método simplificado para reservar um ingresso

O cliente interage apenas com a classe **CinemaFacade**, sem se preocupar com os detalhes internos.

```java
public class Application {
    public static void main(String[] args) {
        //1
        CinemaFacade cinemaFacade = new CinemaFacade();

        //2
        cinemaFacade.bookTicket("Interestelar", 42, "Cartão de Crédito");
    }
}
```
1. Criando a instância do Facade
2. Cliente realiza a reserva de um ingresso

---

### Explicação🤓

1. **Subsistemas**: Temos quatro classes que representam diferentes responsabilidades no processo de reserva de ingressos (`MovieService`, `SeatService`, `PaymentService`, `ConfirmationService`).
2. **Facade**: A classe `CinemaFacade` encapsula as interações entre essas classes e fornece um método simples `bookTicket()` para o cliente realizar a reserva.
3. **Cliente**: O cliente utiliza apenas o método `bookTicket()` para realizar todo o processo de reserva de forma simplificada.

---

### Quando utilizar?🤔

**Facade** é útil quando:
- Quando você deseja fornecer uma interface simplificada para um subsistema complexo.
- Quando há muitas dependências entre classes internas e você deseja ocultar isso do cliente.
- Quando você quer tornar o sistema mais modular e fácil de manter.

---

### Utilização mundo real🌎

- **JDBC (Java Database Connectivity)**: O JDBC fornece uma interface simples para os desenvolvedores interagirem com vários bancos de dados, mas por trás disso, ele esconde toda a complexidade de estabelecer conexões, executar comandos SQL e gerenciar recursos. O JDBC atua como uma Facade para a interação com diferentes bancos de dados.
- **Spring Framework**: Utiliza para simplificar a inicialização e configuração de uma aplicação Spring. A classe `SpringApplication` oferece uma interface simplificada para iniciar uma aplicação Spring Boot, escondendo a complexidade da configuração e inicialização de contexto.
- **Hibernate ORM**: Fornecer uma interface mais simples para interagir com o banco de dados. A classe `SessionFactory` cria instâncias de `Session`, que são usadas para interagir com a base de dados. Essa abordagem oculta a complexidade das operações de persistência e gerenciamento de sessões.

---

Em resumo, é utilizado para fornecer uma interface simplificada para um conjunto de classes ou subsistemas complexos. O objetivo é reduzir a complexidade da interação entre o cliente e o sistema, encapsulando detalhes de implementação e tornando o código mais fácil de usar e manter.