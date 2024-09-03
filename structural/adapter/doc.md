# Padrão Adapter

### Cenário de Problema

Imagine que você está desenvolvendo uma aplicação que trabalha com um sistema de monitoramento de temperatura. Seu sistema utiliza uma interface chamada `TemperatureSensor`, que possui o método `getTemperatureInCelsius()`. No entanto, você precisa integrar um sensor de temperatura de terceiros, que só fornece a temperatura em Fahrenheit através de um método chamado `getTemperatureInFahrenheit()`.

Como essas interfaces são incompatíveis, você precisa de um adaptador que converta a temperatura de Fahrenheit para Celsius e faça com que o sensor de terceiros seja compatível com o sistema existente.

### Exemplo de Código

```java
// Interface esperada pelo sistema
interface TemperatureSensor {
    double getTemperatureInCelsius();
}

// Sensor de terceiros que só trabalha com Fahrenheit
class FahrenheitTemperatureSensor {
    public double getTemperatureInFahrenheit() {
        return 75.0; // Exemplo de temperatura em Fahrenheit
    }
}

// Adapter que converte Fahrenheit para Celsius
class TemperatureAdapter implements TemperatureSensor {
    private FahrenheitTemperatureSensor fahrenheitSensor;

    public TemperatureAdapter(FahrenheitTemperatureSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        double tempInFahrenheit = fahrenheitSensor.getTemperatureInFahrenheit();
        return convertFahrenheitToCelsius(tempInFahrenheit);
    }

    private double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

// Cliente que usa a interface TemperatureSensor
public class Main {
    public static void main(String[] args) {
        // Usando o sensor de terceiros com o adaptador
        FahrenheitTemperatureSensor fahrenheitSensor = new FahrenheitTemperatureSensor();
        TemperatureSensor sensor = new TemperatureAdapter(fahrenheitSensor);

        System.out.println("Temperatura em Celsius: " + sensor.getTemperatureInCelsius());
    }
}
```

### Utilização do Padrão

- **Integração com Código Legado**: O Adapter é útil quando você precisa integrar novos componentes ou sistemas em um código legado que espera uma interface específica.
- **Reutilização de Código**: Permite reutilizar classes existentes em um novo contexto, sem alterar o código dessas classes.
- **Interoperabilidade**: Facilita a comunicação entre componentes que, de outra forma, seriam incompatíveis devido a diferentes interfaces.

No exemplo acima, o `TemperatureAdapter` permite que o sistema trabalhe com um sensor de temperatura de terceiros sem modificar o código do sensor ou do sistema, apenas adaptando a interface.

O **Adapter** é um padrão de design estrutural que permite que interfaces incompatíveis trabalhem juntas. Ele envolve a criação de um "adaptador" que converte a interface de uma classe em outra interface esperada pelo cliente, permitindo que classes com interfaces incompatíveis possam se comunicar.