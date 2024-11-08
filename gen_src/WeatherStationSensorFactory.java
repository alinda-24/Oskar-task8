// File: WeatherStationSensorFactory.java
public class WeatherStationSensorFactory extends SensorFactory {
    @Override
    public Sensor createSensor(String sensorType, double reading) {
        // Method signature only
    }
}

// File: SensorFactory.java
public abstract class SensorFactory {
    public abstract Sensor createSensor(String sensorType, double reading);
}

// File: Sensor.java
public interface Sensor {
    // Interface definition
}

// File: TemperatureSensor.java
public class TemperatureSensor implements Sensor {
    public TemperatureSensor(double reading) {
        // Constructor signature only
    }
}

// File: HumiditySensor.java
public class HumiditySensor implements Sensor {
    public HumiditySensor(double reading) {
        // Constructor signature only
    }
}