package behavioral.state;

public class Application {

    public static void main(String[] args) {

        TrafficLight light = new TrafficLight(new GreenState());

        for (int i = 0; i < 5; i++) {
            light.displayState();
            
            light.changeState();
        }
    }
}
