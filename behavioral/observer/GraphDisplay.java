package behavioral.observer;

import java.util.Arrays;

public class GraphDisplay implements IObserver {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        var params = Arrays.asList(temperature, humidity, pressure).toArray();

        System.out.println("[-----GRÁFICO-----]");
        System.out.printf("Atualizando gráfico: Temp: %5.2f Humidade: %5.2f Pressão: %5.2f\n", params);
    }

}
