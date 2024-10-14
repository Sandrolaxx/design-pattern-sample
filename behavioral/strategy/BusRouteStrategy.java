package behavioral.strategy;

public class BusRouteStrategy implements IRouteStrategy {
 
    @Override
    public void calculateRoute(String from, String to) {
        System.out.print("Calculando rota do busão🚌 de ");
        System.out.print(from + " até " + to + " levando em consideração horários.\n\n");
    }
    
}
