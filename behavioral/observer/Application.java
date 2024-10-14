package behavioral.observer;

public class Application {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        IObserver graphDisplay = new GraphDisplay();
        IObserver weatherAlertDisplay = new WeatherAlertDisplay();

        weatherData.registerObserver(graphDisplay);
        weatherData.registerObserver(weatherAlertDisplay);

        System.out.println("Primeira atualização...");
        weatherData.setMeasurements(36.0f, 65.0f, 1010.0f);
        System.out.println();
        
        System.out.println("Segunda atualização...");
        weatherData.setMeasurements(25.0f, 80.0f, 990.0f);
    }
}
