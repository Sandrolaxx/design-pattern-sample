package behavioral.state;

public class GreenState implements ITrafficLightState {
 
    @Override
    public void change(TrafficLight light) {
        light.setState(new YellowState());
    }

    @Override
    public void display() {
        System.out.println("Sinal verde: Avance✅");
    }

}
