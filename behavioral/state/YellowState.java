package behavioral.state;

public class YellowState implements ITrafficLightState {

    @Override
    public void change(TrafficLight light) {
        light.setState(new RedState());
    }

    @Override
    public void display() {
        System.out.println("Sinal amarelo: Atenção⚠");
    }

}