package creatinonal.prototype;

public abstract class Unit implements IPrototype {
    
    private int health;
    private int attack;
    private int speed;

    public Unit(int health, int attack, int speed) {
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

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
