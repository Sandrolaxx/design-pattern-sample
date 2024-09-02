package creatinonal.abstractfactory;

public class DarkButton implements IButton {

    @Override
    public void render() {
        System.out.println("Btn em dark mode🌛");
    }

}
