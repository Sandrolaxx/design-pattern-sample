package behavioral.visitor;

public class COFINSCalculatorVisitor implements IVisitor {

    private static final Double COFINS_RATE = 0.0765;

    @Override
    public void visit(Product product) {
        Double cofins = product.getPrice() * COFINS_RATE;

        System.out.println("Calculando COFINS para o produto: " + product.getName() + " - COFINS: " + cofins);
    }
    
}
