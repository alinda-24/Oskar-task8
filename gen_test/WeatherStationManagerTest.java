package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherStationManagerTest {

    @Test
    public void testLoadWeatherStationsValidFile() {
        WeatherStationManager manager = new WeatherStationManager();
        manager.loadWeatherStations("valid_weather_config.txt");
        List<WeatherStation> stations = manager.getWeatherStations();
        assertEquals(3, stations.size());
    }

    @Test
    public void testLoadWeatherStationsInvalidReading() {
        WeatherStationManager manager = new WeatherStationManager();
        manager.loadWeatherStations("invalid_weather_config.txt"); // Assume this file has invalid readings
        List<WeatherStation> stations = manager.getWeatherStations();
        assertEquals(0, stations.size()); // Should skip invalid readings
    }

    @Test
    public void testDisplayWeatherDataAndForecasts() {
        WeatherStationManager manager = new WeatherStationManager();
        manager.loadWeatherStations("valid_weather_config.txt");
        manager.displayWeatherDataAndForecasts(); // Just ensures it runs, would need to check console for real verification
    }
}

// WeatherStationTest.java
import org.junit.Test;
import static org.junit.Assert.*;

