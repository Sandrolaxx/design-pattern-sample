package structural.flyweight;

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
