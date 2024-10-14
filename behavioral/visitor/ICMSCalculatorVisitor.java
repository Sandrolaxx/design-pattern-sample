package behavioral.visitor;

public class ICMSCalculatorVisitor implements IVisitor {

    private static final Double ICMS_RATE = 0.18;

    @Override
    public void visit(Product product) {
        Double icms = product.getPrice() * ICMS_RATE;

        System.out.println("Calculando ICMS para o produto: " + product.getName() + " - ICMS: " + icms);
    }
    
}
