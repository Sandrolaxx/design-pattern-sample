package behavioral.strategy;

public class RouteContext {

    private IRouteStrategy strategy;

    public void setStrategy(IRouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String from, String to) {
        strategy.calculateRoute(from, to);
    }

}
