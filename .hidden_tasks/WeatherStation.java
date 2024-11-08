public class WeatherStation {
    private String location;
    private Sensor sensor;
    
    public WeatherStation(String location, Sensor sensor) {
        this.location = location;
        this.sensor = sensor;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Sensor getSensor() {
        return sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
    public void calculateForecast() {
        // Simple prediction logic
        if (sensor instanceof TemperatureSensor) {
            double reading = ((TemperatureSensor) sensor).getReading();
            if (reading > 30) {
                System.out.println("It's going to be a hot day in " + location);
            } else {
                System.out.println("Temperature is moderate in " + location);
            }
        } else if (sensor instanceof HumiditySensor) {
            double reading = ((HumiditySensor) sensor).getReading();
            if (reading > 70) {
                System.out.println("High humidity expected in " + location);
            } else {
                System.out.println("Humidity levels are normal in " + location);
            }
        }
    }
}

// Sensor.java

public interface Sensor {
    String getType();
}