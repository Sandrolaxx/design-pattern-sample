# Flyweight🏋

### Cenário do problema:

Imagine que você está criando um **Age of Empiers** com inúmeras personagens no campo de batalha. Cada personagem tem um **tipo** (por exemplo, arqueiro, cavaleiro, mago) e **atributos** específicos (força, velocidade, etc.). No entanto, muitos personagens compartilham o mesmo **tipo**, logo, criar uma nova instância de cada tipo para cada personagem resultaria em desperdício de memória. Também temos de respeitar os valores específicos de cada instância, como a localização no campo de batalha.

---

### Utilização do padrão✅

Para resolver isso, podemos usar o padrão **Flyweight** e **compartilhar os tipos** entre os personagens, economizando memória ao não duplicar os dados repetidos.

---

### Exemplo em Java☕

```java
//1
class CharacterType {
    private String name;
    private String weapon;
    private String armor;

    public CharacterType(String name, String weapon, String armor) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void displayCharacter(int x, int y) {
        System.out.println(name + " equipado com " + weapon + " e " + armor + " posicionado em (" + x + ", " + y + ")");
    }
}
```
1. Classe Flyweight: Tipo de Personagem

```java
import java.util.HashMap;
import java.util.Map;

//1
class CharacterFactory {
    private static Map<String, CharacterType> characterTypes = new HashMap<>();

    public static CharacterType getCharacterType(String name, String weapon, String armor) {
        String key = name + weapon + armor;
        CharacterType type = characterTypes.get(key);
        
        if (type == null) {
            type = new CharacterType(name, weapon, armor);
            characterTypes.put(key, type);
        }

        return type;
    }
}
```
1. Flyweight Factory: Gerencia os tipos de personagens

```java
//1
class GameCharacter {
    private int x;
    private int y;
    private CharacterType type;

    public GameCharacter(int x, int y, CharacterType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void display() {
        type.displayCharacter(x, y);
    }
}
```
1. Classe Personagem: Representa um personagem no jogo, armazena as informações específicas que são exclusivas de cada instância (como as coordenadas no campo de batalha).

```java
public class Application {
    public static void main(String[] args) {
        CharacterType archerType = CharacterFactory.getCharacterType("Arqueiro", "Arco e Flecha", "Couro");
        CharacterType knightType = CharacterFactory.getCharacterType("Cavaleiro", "Espada", "Armadura de Aço");
        
        //1
        GameCharacter character1 = new GameCharacter(10, 20, archerType);
        GameCharacter character2 = new GameCharacter(30, 40, archerType);
        GameCharacter character3 = new GameCharacter(50, 60, knightType);
        GameCharacter character4 = new GameCharacter(70, 80, knightType);

        //2
        character1.display();
        character2.display();
        character3.display();
        character4.display();
    }
}
```
1. Criando personagens
2. Exibindo os personagens no campo de batalha

---

### Explicação🤓

1. **Flyweight (CharacterType)**: A classe `CharacterType` representa o tipo de personagem (Arqueiro, Cavaleiro, etc.) com atributos compartilhados como armas e armaduras.
2. **Flyweight Factory (CharacterFactory)**: A fábrica de flyweights (`CharacterFactory`) garante que os tipos de personagens sejam criados uma única vez e compartilhados entre todas as instâncias de personagens que precisem desse tipo.
3. **Cliente (GameCharacter)**: A classe `GameCharacter` usa o flyweight `CharacterType` para determinar o tipo do personagem e armazena as coordenadas individuais no campo de batalha.

---

### Quando utilizar?🤔

**Flyweight** é útil quando:
- Quando seu sistema cria **muitas instâncias** de objetos que compartilham dados idênticos.
- Quando você quer **economizar memória** ao compartilhar objetos entre instâncias, em vez de duplicá-los.
- Ideal para cenários como jogos (personagens, gráficos), sistemas de texto (compartilhamento de fontes), e cache de dados.

---

### Utilização mundo real🌎

- **Java AWT/Swing**: Gerenciar fontes e cores. Em vez de criar uma nova instância de `Font` ou `Color` para cada componente gráfico, essas classes utilizam uma abordagem compartilhada para garantir que múltiplos componentes possam usar a mesma instância de fonte ou cor, economizando memória e melhorando a performance.
- **JVM (Java Virtual Machine)**: Utiliza um pool de strings para armazenar strings que são usadas repetidamente. O padrão Flyweight é aplicado aqui, pois strings iguais são armazenadas em uma única instância no pool de strings, reduzindo a quantidade de memória necessária para armazenar duplicatas de strings.
- **Jogos**: Em jogos ou sistemas gráficos, o padrão Flyweight pode ser usado para representar objetos gráficos ou entidades de jogo que compartilham características comuns, como sprites, texturas ou estados.

---

Em resumo, é utilizado para reduzir o consumo de memória ao compartilhar objetos comuns em um sistema, principalmente quando há muitos objetos similares. Ele foca em **maximizar o uso de objetos reutilizáveis** e minimizar o uso de memória ao manter os dados que podem ser compartilhados separados dos que são únicos para cada instância.