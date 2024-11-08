// WeatherStation.java

public class WeatherStation {
    private String location;
    private Sensor sensor;
    
    public WeatherStation(String location, Sensor sensor) {
        // Constructor
    }
    
    public String getLocation() {
        // Get location
    }
    
    public void setLocation(String location) {
        // Set location
    }
    
    public Sensor getSensor() {
        // Get sensor
    }
    
    public void setSensor(Sensor sensor) {
        // Set sensor
    }
    
    public void calculateForecast() {
        // Calculate forecast
    }
}

// Sensor.java

public interface Sensor {
    String getType();
}