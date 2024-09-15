package structural.flyweight;

public class Application {

    public static void main(String[] args) {

        CharacterType archerType = CharacterFactory.getCharacterType("Arqueiro", "Arco e Flecha", "Couro");
        CharacterType knightType = CharacterFactory.getCharacterType("Cavaleiro", "Espada", "Armadura de Aço");

        GameCharacter character1 = new GameCharacter(10, 20, archerType);
        GameCharacter character2 = new GameCharacter(30, 40, archerType);
        GameCharacter character3 = new GameCharacter(50, 60, knightType);
        GameCharacter character4 = new GameCharacter(70, 80, knightType);

        character1.display();
        character2.display();
        character3.display();
        character4.display();
    }

}
