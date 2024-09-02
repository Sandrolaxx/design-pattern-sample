package creatinonal.abstractfactory;

public class DarkThemeFactory implements IGUIFactory {
    
    @Override
    public IButton createButton() {
        return new DarkButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new DarkTextBox();
    }

}