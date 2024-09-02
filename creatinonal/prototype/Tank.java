package creatinonal.prototype;

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
