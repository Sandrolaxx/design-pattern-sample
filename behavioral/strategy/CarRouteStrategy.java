package behavioral.strategy;

public class CarRouteStrategy implements IRouteStrategy {
 
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota para carro🚗 de ");
        System.out.print(from + " até " + to + " priorizando rodovias.\n\n");
    }
    
}
