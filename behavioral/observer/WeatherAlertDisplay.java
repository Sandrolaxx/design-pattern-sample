package behavioral.observer;

public class WeatherAlertDisplay implements IObserver {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("[-----ALERTA-----]");

        if (temperature > 35) {
            System.out.println("Alerta de calor extremo! Temp: " + temperature);
        } else if (pressure < 1000) {
            System.out.println("Alerta de tempestade! Pressão: " + pressure);
        }
    }

}
