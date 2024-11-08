package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherStationSensorFactoryTest {

    @Test
    public void testCreateTemperatureSensor() {
        WeatherStationSensorFactory factory = new WeatherStationSensorFactory();
        Sensor sensor = factory.createSensor("Temperature", 25.0);
        assertTrue(sensor instanceof TemperatureSensor);
    }

    @Test
    public void testCreateHumiditySensor() {
        WeatherStationSensorFactory factory = new WeatherStationSensorFactory();
        Sensor sensor = factory.createSensor("Humidity", 60.0);
        assertTrue(sensor instanceof HumiditySensor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUnknownSensor() {
        WeatherStationSensorFactory factory = new WeatherStationSensorFactory();
        factory.createSensor("Pressure", 101.3); // Invalid sensor type
    }
}

// WeatherStationManagerTest.java
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

