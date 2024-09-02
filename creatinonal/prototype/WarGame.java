package creatinonal.prototype;

public class WarGame {
    public static void main(String[] args) {

        Soldier soldier = new Soldier(100, 20, 5);
        System.out.println("🪖Soldado original: " + soldier);

        Soldier clonedSoldier = soldier.clone();
        System.out.println("🪖Soldado clonado: " + clonedSoldier);

        Tank guarani = new Tank(300, 50, 2);
        System.out.println("(VBTP)Tanque original: " + guarani);

        Tank clonedGuarani = guarani.clone();
        System.out.println("(VBTP)Tanque clonado: " + clonedGuarani);

    }

}
