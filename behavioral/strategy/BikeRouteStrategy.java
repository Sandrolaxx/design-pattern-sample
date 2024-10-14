package behavioral.strategy;

public class BikeRouteStrategy implements IRouteStrategy {
 
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota para bicicleta🚲 de ");
        System.out.print(from + " até " + to + " evitando ruas movimentadas.\n\n");
    }
    
}
