package behavioral.strategy;

public class Application {

    public static void main(String[] args) {
        RouteContext context = new RouteContext();

        //1
        context.setStrategy(new BikeRouteStrategy());
        context.executeStrategy("Avenida Brasil", "Praça Migrante");

        //2
        context.setStrategy(new CarRouteStrategy());
        context.executeStrategy("Avenida Fag", "HubOne");

        //3
        context.setStrategy(new BusRouteStrategy());
        context.executeStrategy("Rua barão do cerro azul, 1250", "Rua xavantes");
    }
    
}
