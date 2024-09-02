package creatinonal.abstractfactory;

public class DarkTextBox implements ITextBox {

    @Override
    public void render() {
        System.out.println("Caixa de texto em dark mode🌛");
    }
    
}
