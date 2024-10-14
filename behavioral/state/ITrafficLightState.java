package behavioral.state;

public interface ITrafficLightState {
    
    void change(TrafficLight light);

    void display();
    
}