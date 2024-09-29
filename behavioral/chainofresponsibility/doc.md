# Chain of Responsibility⛓

### Cenário de problema🖱️

Imagine que você está desenvolvendo um sistema de suporte técnico para uma empresa que oferece vários níveis de atendimento. Os clientes podem ter problemas de diferentes níveis de complexidade: simples, intermediários e complexos. Dependendo da complexidade do problema, ele pode ser resolvido por um atendente, um técnico de nível 1, 2 ou 3. 

Implementar essa lógica diretamente pode gerar um código confuso, onde cada função precisaria lidar com problemas de todos os níveis. Além disso, se no futuro for necessário adicionar um novo nível de suporte, seria preciso modificar várias partes do sistema.

---

### Utilização do padrão✅

O padrão **Chain of Responsibility** é ideal para este cenário porque permite que cada nível de suporte tente resolver o problema. Se não for capaz de resolver, o problema é passado para o próximo nível na cadeia. Isso desacopla o processo de decisão e facilita a manutenção e extensão do sistema, já que novos níveis de suporte podem ser adicionados sem alterar os níveis existentes.

---

### Exemplo em Java☕

Aqui está um exemplo da implementação do padrão Chain of Responsibility em Java:

```java
// 1
public abstract class Support {

    protected Support nextLevel;

    public void setNextLevel(Support nextLevel) {
        this.nextLevel = nextLevel;
    }

    public abstract void solveProblem(String problemType);
}
```

1. Definimos uma classe abstrata `Support` que representa um nível de suporte. Ela contém um método abstrato `solveProblem` e uma referência ao próximo nível de suporte.

```java
// 1
public class TechnicalLevelOne extends Support {

    @Override
    public void solveProblem(String problemType) {
        if (problemType.equalsIgnoreCase("low")) {
            System.out.println("N1 resolveu o problema de baixa complexidade. Mais um pro pai😎.");
        } else {
            System.out.println("N1 não conseguiu resolver😢. Encaminhando para o N2...");
            if (nextLevel != null) {
                nextLevel.solveProblem(problemType);
            }
        }
    }
}
```

1. O **N1** tenta resolver problemas simples. Se não conseguir, passa o problema ao próximo nível.

```java
//1
public class TechnicalLevelTwo extends Support {

    @Override
    public void solveProblem(String problemType) {
        if (problemType.equalsIgnoreCase("intermediate")) {
            System.out.println("N2 resolveu o problema de complexidade intermediária. Easy🚀");
        } else {
            System.out.println("N2 não conseguiu resolver😞. Encaminhando para o N3...");
            if (nextLevel != null) {
                nextLevel.solveProblem(problemType);
            }
        }
    }
}
```

1. O **N2** resolve problemas de complexidade intermediária. Caso não resolva, encaminha para o próximo nível.

```java
//1
public class TechnicalLevelThree extends Support {
    
    @Override
    public void solveProblem(String problemType) {
        if (problemType.equalsIgnoreCase("complex")) {
            System.out.println("N3 resolveu o problema de alta complexidade🤓");
        } else {
            System.out.println("N3 não conseguiu resolver😭. Agora já era. Só os sênior de 16 anos de empresa para resolver🙏");
        }
    }
}
```

1. O **N3** resolve problemas complexos. Se não conseguir, indica que o problema não foi resolvido, só as lendas agora.

---

### Utilizando Chain of Responsibility

Aqui está um exemplo de utilização do padrão Chain of Responsibility, onde simulamos diferentes tipos de problemas:

```java
public class SupportClient {
    public static void main(String[] args) {
        //1
        Support n1 = new TechnicalLevelOne();
        Support n2 = new TechnicalLevelTwo();
        Support n3 = new TechnicalLevelThree();

        //2
        n1.setNextLevel(n2);
        n2.setNextLevel(n3);

        //3
        System.out.println("Chamado 1: Problema simples");
        n1.solveProblem("low");

        System.out.println("\nChamado 2: Problema intermediário");
        n1.solveProblem("intermediate");

        System.out.println("\nChamado 3: Problema complexo");
        n1.solveProblem("complex");

        System.out.println("\nChamado 4: Problema desconhecido");
        n1.solveProblem("unknown");
    }
}
```

1. Criamos as instâncias dos diferentes níveis de suporte: **TechnicalLevelOne**, **TechnicalLevelTwo**, e **TechnicalLevelThree**.
2. Configuramos a cadeia de responsabilidade, ligando cada nível ao próximo.
3. Simulamos a resolução de problemas de diferentes níveis de complexidade.

---

### Explicação🤓

- **Classe abstrata `Support`:** Define a interface para todos os níveis de suporte, com um método `solveProblem` e uma referência ao próximo nível na cadeia.
- **Classes concretas (`TechnicalLevelOne`, `TechnicalLevelTwo`, `TechnicalLevelThree`):** Implementam a lógica para resolver problemas de diferentes níveis de complexidade. Cada nível tenta resolver o problema e, se não conseguir, passa o problema para o próximo.
- **Cliente `SupportClient`:** Configura a cadeia de suporte e envia diferentes problemas para serem resolvidos, observando como cada nível de suporte interage.

---

### Quando utilizar?🤔

**Chain of Responsibility** é útil quando:
- Você deseja processar uma solicitação por uma cadeia de objetos, onde cada objeto tem a oportunidade de processar a solicitação ou passá-la adiante.
- Você deseja desacoplar o remetente da solicitação de seus manipuladores, promovendo flexibilidade e extensibilidade no sistema.
- A sequência de manipuladores pode ser alterada dinamicamente, ou novos manipuladores podem ser adicionados sem impactar o código existente.

---

### Utilização mundo real🌎

- **Frameworks de processamento de requisições HTTP (Ex: filtros de servlet em Java EE):** O padrão Chain of Responsibility é utilizado para passar requisições através de uma cadeia de filtros, onde cada filtro tem a opção de processar a requisição ou encaminhá-la adiante.
- **Gerenciamento de eventos em sistemas de interface gráfica:** O Chain of Responsibility pode ser utilizado para gerenciar eventos como cliques de botão, onde diferentes partes do sistema podem ter a chance de processar o evento.

Esse padrão é utilizado quando há uma série de objetos responsáveis por tentar processar uma solicitação, e você quer manter a flexibilidade para modificar a ordem ou os tipos de processamento facilmente.