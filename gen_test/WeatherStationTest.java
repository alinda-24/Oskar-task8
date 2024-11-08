package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherStationTest {

    @Test
    public void testCalculateForecastTemperatureSensor() {
        TemperatureSensor sensor = new TemperatureSensor(35.0);
        WeatherStation station = new WeatherStation("Location1", sensor);
        assertEquals("It's going to be a hot day in Location1", station.calculateForecast());
    }

    @Test
    public void testCalculateForecastHumiditySensor() {
        HumiditySensor sensor = new HumiditySensor(80.0);
        WeatherStation station = new WeatherStation("Location2", sensor);
        assertEquals("High humidity expected in Location2", station.calculateForecast());
    }
}

// CommandParserTest.java
import org.junit.Test;
import static org.junit.Assert.*;

