package behavioral.state;

public class TrafficLight {

    private ITrafficLightState state;

    public TrafficLight(ITrafficLightState initialState) {
        this.state = initialState;
    }

    public void setState(ITrafficLightState state) {
        this.state = state;
    }

    public void changeState() {
        state.change(this);
    }

    public void displayState() {
        state.display();
    }

}
