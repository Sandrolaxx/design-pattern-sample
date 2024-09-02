package creatinonal.prototype;

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
