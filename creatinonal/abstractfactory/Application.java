package creatinonal.abstractfactory;

public class Application {
    private IButton iButton;
    private ITextBox iTextBox;

    public Application(IGUIFactory factory) {
        iButton = factory.createButton();
        iTextBox = factory.createTextBox();
    }

    public void render() {
        iButton.render();
        iTextBox.render();
    }

    public static void main(String[] args) {
        IGUIFactory factory;

        String theme = "dark";

        if (theme.equals("light")) {
            factory = new LightThemeFactory();
        } else {
            factory = new DarkThemeFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
}
