# Interpreter

### Cenário de problema➗

Imagine que você está desenvolvendo uma calculadora para expressões matemáticas simples (como somar, subtrair, multiplicar e dividir). Os usuários podem inserir expressões matemáticas no formato de texto, como `3 + 5`, e a calculadora deve interpretar e avaliar a expressão corretamente.

Implementar a lógica de interpretação diretamente no código da calculadora pode resultar em um sistema rígido e difícil de estender, especialmente se os operadores ou as regras de precedência mudarem ou novos operadores forem adicionados no futuro. Além disso, analisar expressões e interpretá-las manualmente torna o código mais complexo e difícil de manter.

---

### Utilização do padrão✅

O padrão **Interpreter** é ideal para este cenário, pois define uma gramática para representar as expressões e fornece um mecanismo para interpretar essas expressões. Ele permite criar classes para cada operação ou símbolo da gramática, encapsulando a lógica de interpretação dentro dessas classes. Com isso, a adição de novos operadores ou a modificação das regras de avaliação se torna simples, sem a necessidade de modificar a estrutura principal da calculadora.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Interpreter em Java para um cenário de calculadora de expressões:

```java
// 1
public interface Expression {
    int interpret();
}
```

1. Interface **Expression** que define o método `interpret`, responsável por avaliar a expressão.

```java
// 1
public class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
```

1. Classe **Number** que implementa a interface `Expression`. Essa classe representa números na expressão.

```java
// 1
public class Sum implements Expression {
    private Expression left;

    private Expression right;

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
```

1. Classe **Sum** que implementa a operação de soma entre duas expressões.

```java
// 1
public class Sub implements Expression {
    private Expression left;

    private Expression right;

    public Sub(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
```

1. Classe **Sub** que implementa a operação de subtração entre duas expressões.

---

### Utilizando Interpreter

Agora vamos construir uma expressão utilizando o padrão Interpreter para interpretar expressões como `10 + 5 - 3`.

```java
public class Application {
    public static void main(String[] args) {
        //1
        Expression expressao = new Sub(
            new Sum(new Number(10), new Number(5)), 
            new Number(3)
        );

        //2
        int resultado = expressao.interpret();

        System.out.println("Resultado: " + resultado);
    }
}
```

1. Construímos uma expressão composta por `10 + 5 - 3` utilizando objetos de **Number**, **Sum** e **Sub**.
2. O método `interpret` é chamado na expressão para avaliar o resultado.

---

### Explicação🤓

- **Interface `Expression`:** Define o contrato para todas as expressões com o método `interpret`. Cada expressão concreta (como número ou operação) deve implementar esse método.
- **Classes concretas (`Number`, `Sum`, `Sub`):** Representam elementos da gramática de expressões. A classe `Number` representa valores numéricos, enquanto `Sum` e `Sub` implementam operações aritméticas.
- **Composição de expressões:** As operações são compostas utilizando objetos de expressões, permitindo criar expressões complexas de maneira hierárquica e flexível.

---

### Quando utilizar?🤔

O padrão **Interpreter** é útil quando:
- Você precisa interpretar expressões ou linguagens simples e a gramática pode ser representada como uma árvore.
- Você quer definir um conjunto de operações simples sobre uma gramática definida, como operadores matemáticos, comandos ou instruções de linguagem.
- O sistema é extensível, permitindo que novas expressões sejam adicionadas facilmente.

---

### Utilização mundo real🌎

- **Compiladores e interpretadores de linguagens:** Usam o padrão Interpreter para analisar e interpretar código fonte, transformando as instruções em ações executáveis.
- **Sistemas de validação de regras de negócio:** Empresas podem usar o padrão Interpreter para definir e validar regras de negócio dinâmicas a partir de uma linguagem de regras.
- **Analisadores de expressões regulares:** Alguns motores de regex utilizam conceitos semelhantes ao padrão Interpreter para analisar e processar expressões regulares.

---

Este padrão é ideal para cenários onde a flexibilidade para interpretar uma linguagem ou gramática simples é necessária, facilitando a extensão e a clareza do código.