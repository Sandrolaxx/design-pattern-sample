package structural.adapter;

public class Application {

    public static void main(String[] args) {

        BRPlug brazilianPlug = new BRPlug();

        IUKPlug unitedKingdomPlug = new PlugAdapter(brazilianPlug);

        unitedKingdomPlug.connectToUnitedKingdomSocket();
    }
}
