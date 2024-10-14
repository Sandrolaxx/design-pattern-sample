package behavioral.visitor;

public class ISSCalculatorVisitor implements IVisitor {
 
    private static final Double ISS_RATE = 0.05;

    @Override
    public void visit(Product product) {
        Double iss = product.getPrice() * ISS_RATE;
        
        System.out.println("Calculando ISS para o serviço: " + product.getName() + " - ISS: " + iss);
    }

}
