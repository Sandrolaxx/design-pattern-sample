package structural.adapter;

class PlugAdapter implements IUKPlug {

    private BRPlug brPlug;

    public PlugAdapter(BRPlug brPlug) {
        this.brPlug = brPlug;
    }

    @Override
    public void connectToUnitedKingdomSocket() {
        System.out.println("Usando um adaptador de tomada...🔄");

        brPlug.connectToBrazilianSocket();
    }

}
