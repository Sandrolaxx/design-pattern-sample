package creatinonal.abstractfactory;

public class LightThemeFactory implements IGUIFactory {

    @Override
    public IButton createButton() {
        return new LightButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new LightTextBox();
    }
    
}
