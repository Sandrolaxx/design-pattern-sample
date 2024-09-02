# Prototype

### Cenário de problema🗺

Imagine que você está desenvolvendo um WAR online(jogo de estratégia de guerra) onde há diversos tipos de unidades, como soldados, tanques e aviões. Cada unidade tem um conjunto de atributos, como pontos de vida, ataque e velocidade. Criar novas unidades no jogo a partir do zero pode ser custoso em termos de tempo e recursos, especialmente se elas compartilham muitos dos mesmos atributos.

Se você criar cada unidade manualmente, isso resultará em duplicação de código e dificultará a manutenção do sistema. Além disso, alterar as configurações de uma unidade em particular seria complexo e propenso a erros.

---

### Utilização do padrão✅

O padrão **Prototype** é ideal para este cenário porque permite criar novos objetos clonando instâncias existentes, em vez de criar novos objetos do zero. Isso é especialmente útil quando o custo de criação de um objeto é caro ou complexo, e quando você precisa criar múltiplas instâncias de um objeto que compartilham a maior parte de suas configurações.

---

### Exemplo em Java☕

Aqui está um exemplo de como implementar o padrão Prototype em Java para o cenário descrito:

```java
//1
public interface IPrototype {
    IPrototype clone();
}
```

1. Interface IPrototype que define o método de clonagem

```java
//1
public abstract class Unit implements IPrototype {
    private int health;
    private int attack;
    private int speed;

    public Unit(int health, int attack, int speed) {
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    //2
    public Unit(Unit target) {
        if (target != null) {
            this.health = target.health;
            this.attack = target.attack;
            this.speed = target.speed;
        }
    }

    @Override
    public abstract Unit clone();

    @Override
    public String toString() {
        return "Health: " + health + ", Attack Power: " + attack + ", Speed: " + speed;
    }
}
```

1. Classe concreta Unidade (Unit) que implementa IPrototype
2. Construtor que permite realizar a clonagem

```java
//1
public class Soldier extends Unit {
    public Soldier(int health, int attack, int speed) {
        super(health, attack, speed);
    }

    public Soldier(Soldier target) {
        super(target);
    }

    @Override
    public Soldier clone() {
        return new Soldier(this);
    }
}
```

1. Classe Soldado (Soldier) que estende Unidade (Unit)

```java
//1
public class Tank extends Unit {
    public Tank(int health, int attack, int speed) {
        super(health, attack, speed);
    }

    public Tank(Tank target) {
        super(target);
    }

    @Override
    public Tank clone() {
        return new Tank(this);
    }
}
```

1. Classe Tanque (Tank) que estende Unidade (Unit)

### Utilizando Prototype no sistema do jogo

Abaixo exemplo de utilização do padrão Prototype para criar e clonar unidades no jogo:

```java
public class WarGame {
    public static void main(String[] args) {
        //1
        Soldier soldier = new Soldier(100, 20, 5);
        System.out.println("🪖Soldado original: " + soldier);

        //2
        Soldier clonedSoldier = soldier.clone();
        System.out.println("🪖Soldado clonado: " + clonedSoldier);

        //3
        Tank guarani = new Tank(300, 50, 2);
        System.out.println("(VBTP)Tanque original: " + guarani);

        //4
        Tank clonedGuarani = guarani.clone();
        System.out.println("(VBTP)Tanque clonado: " + clonedGuarani);
    }
}
```

1. Criação de uma unidade Soldado
2. Clonando o Soldado para criar uma nova unidade
3. Criação de uma unidade Tanque
4. Clonando o Tanque para criar uma nova unidade

---

### Explicação🤓

- **Interface `IPrototype`:** Define o método `clone()` que será implementado pelas classes que desejam permitir a clonagem de seus objetos.

- **Classe `Unit`:** É uma classe abstrata que implementa a interface `IPrototype`. Ela contém atributos comuns a todas as unidades, como `health`, `attack`, e `speed`. O método `clone()` é declarado como abstrato, forçando subclasses a implementar sua própria versão de clonagem.

- **Classes concretas (`Soldier` e `Tank`):** Cada uma dessas classes estende `Unit` e implementa o método `clone()` para criar uma cópia de si mesma. Elas também possuem construtores que aceitam uma instância da própria classe como parâmetro para realizar a clonagem dos atributos.

- **Desacoplamento:** Usando o padrão Prototype, o jogo pode criar novas unidades facilmente e de forma eficiente, simplesmente clonando unidades existentes. Isso evita a duplicação de código e simplifica o processo de criação de novas instâncias de objetos complexos.

---

### Quando utilizar?🤔

Prototype é útil quando:
- O custo de criar uma nova instância de um objeto é significativo em termos de tempo ou recursos.
- O sistema requer a criação de objetos que são variações ou cópias de um conjunto existente de objetos.
- Você deseja evitar a duplicação de código ao criar objetos semelhantes ou com pequenas modificações.

Esse padrão é frequentemente utilizado em jogos, editores gráficos, e sistemas de CAD, onde a criação e manipulação de objetos complexos precisam ser rápidas e eficientes.