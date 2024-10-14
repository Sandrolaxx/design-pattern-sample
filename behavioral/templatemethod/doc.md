# Template Method

### Cenário de problema💳🏦

Imagine que você está desenvolvendo um sistema para processar transações com diferentes **adquirentes de cartão** (empresas responsáveis por processar transações de cartão). Todas as adquirentes possuem a funcionalidade básica de **realizar transações**, mas algumas também oferecem funcionalidades adicionais, como **links de pagamento** e **transações recorrentes**.

Se implementarmos o processo de transação para cada adquirente separadamente, isso resultará em muito código duplicado. Em vez disso, queremos reaproveitar o código comum (como realizar transação) e permitir que as adquirentes específicas decidam se oferecem links de pagamento ou recorrência.

---

### Utilização do padrão✅

O padrão **Template Method** é perfeito para esse cenário, pois permite definir o esqueleto do processo de transação na classe base, e as subclasses podem decidir se querem implementar ou não funcionalidades adicionais, como links de pagamento ou recorrência.

---

### Exemplo em Java☕

Abaixo uma implementação do padrão **Template Method** para adquirentes de cartão:

```java
//1
public abstract class IAcquirer {
    //2
    public final void processTransaction() {
        validateCard();
        authorizeTransaction();
        
        if (supportsPaymentLink()) {
            generatePaymentLink();
        }

        if (supportsRecurringPayment()) {
            setupRecurringPayment();
        }

        finishTransaction();
    }

    //3
    protected abstract void validateCard();
    protected abstract void authorizeTransaction();

    //4
    protected boolean supportsPaymentLink() { 
        return false; 
    }

    protected boolean supportsRecurringPayment() { 
        return false; 
    }

    protected void generatePaymentLink() {}

    protected void setupRecurringPayment() {}

    //5
    protected void finishTransaction() {
        System.out.println("Finalizando a transação.");
    }
}
```
1. Classe abstrata `IAcquirer` (esqueleto do algoritmo).
2. O método `processTransaction()` é o template method que define o esqueleto do processo de transação.
3. Métodos abstratos a serem implementados pelas subclasses.
4. Métodos que podem ou não ser implementados pelas subclasses.
5. Método comum para finalizar transação.

```java
//1
public class Stone extends IAcquirer {
    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão na Stone.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação na Stone.");
    }

    //2
    @Override
    protected boolean supportsPaymentLink() {
        return true;
    }

    @Override
    protected void generatePaymentLink() {
        System.out.println("Gerando link de pagamento na Stone.");
    }
}
```
1. Subclasse específica - Adquirente Stone
2. Adquirente **Stone** suporta link de pagamento

```java
//1
public class Cielo extends IAcquirer {
    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão na Cielo.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação na Cielo.");
    }

    //2
    @Override
    protected boolean supportsRecurringPayment() {
        return true;
    }

    @Override
    protected void setupRecurringPayment() {
        System.out.println("Configurando pagamento recorrente na Cielo.");
    }
}
```
1. Subclasse específica - Adquirente Cielo
2. Adquirente **Cielo** suporta transações recorrentes

```java
//1
public class Rede extends IAcquirer {
    //2
    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão no Rede.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação no Rede.");
    }
}
```
1. Subclasse específica - Adquirente Rede
2. Adquirente **Rede** só realiza transações básicas 

### Utilizando o padrão:

```java
public class Application {
    public static void main(String[] args) {
        IAcquirer stone = new Stone();
        IAcquirer cielo = new Cielo();
        IAcquirer rede = new Rede();

        System.out.println("Processando transação na Stone:");
        stone.processTransaction();

        System.out.println("\nProcessando transação na Cielo:");
        cielo.processTransaction();

        System.out.println("\nProcessando transação na Rede:");
        rede.processTransaction();
    }
}
```

---

### Explicação🤓

- **Classe abstrata `IAcquirer`:** Define o esqueleto do processo de transação no método `processTransaction()`. As subclasses podem decidir se suportam funcionalidades adicionais, como links de pagamento e recorrência, implementando ou sobrescrevendo os métodos `supportsPaymentLink()` e `supportsRecurringPayment()`.
- **Subclasses `Stone`, `Cielo`, `Rede`:** Cada adquirente pode implementar diferentes comportamentos, como gerar links de pagamento ou configurar transações recorrentes, de acordo com os serviços que oferecem.

---

### Quando utilizar?🤔

Use **Template Method** quando:
- Há um processo comum com variações em algumas etapas que diferentes classes precisam implementar.
- Você deseja evitar duplicação de código ao reutilizar a lógica comum, permitindo que as subclasses personalizem partes específicas do algoritmo.

---

### Utilização no mundo real🌎

- **Frameworks de testes unitários (JUnit)**: O ciclo de execução de testes (setup, teste, teardown) é padronizado, com variação nos métodos `setUp()` e `tearDown()`.
- **Sistemas de relatórios**: Geração de relatórios com estrutura comum para coleta e formatação de dados, variando o formato de saída (PDF, CSV, Excel).
- **Frameworks Web (Spring)**: O ciclo de vida das requisições HTTP é definido em métodos padrão, com diferentes formas de processar as requisições.
- **Manipulação de arquivos**: Processamento de arquivos padronizado em operações de abrir, ler e fechar, com variações para formatos como JSON, XML e texto.
