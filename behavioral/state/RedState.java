package behavioral.state;

public class RedState implements ITrafficLightState {

    @Override
    public void change(TrafficLight light) {
        light.setState(new GreenState());
    }

    @Override
    public void display() {
        System.out.println("Sinal vermelho: Pare🔴");
    }

}
