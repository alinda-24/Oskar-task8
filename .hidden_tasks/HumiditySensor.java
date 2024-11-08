public class HumiditySensor implements Sensor {
    private double reading;
    
    public HumiditySensor(double reading) {
        this.reading = reading;
    }
    
    public double getReading() {
        return reading;
    }
    
    public void setReading(double reading) {
        this.reading = reading;
    }
    
    @Override
    public String getType() {
        return "Humidity";
    }
}

// SensorFactory.java

public abstract class SensorFactory {
    public abstract Sensor createSensor(String sensorType, double reading);
}