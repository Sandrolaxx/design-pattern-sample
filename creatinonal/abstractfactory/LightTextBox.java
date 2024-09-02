package creatinonal.abstractfactory;

public class LightTextBox implements ITextBox {

    @Override
    public void render() {
        System.out.println("Caixa de texto em light mode🌞");
    }

}