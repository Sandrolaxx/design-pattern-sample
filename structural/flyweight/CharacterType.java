package structural.flyweight;

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
