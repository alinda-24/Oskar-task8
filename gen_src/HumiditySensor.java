// HumiditySensor.java

public class HumiditySensor implements Sensor {
    
    public HumiditySensor(double reading) {
        // Constructor
    }
    
    public double getReading() {
        // Method
    }
    
    public void setReading(double reading) {
        // Method
    }
    
    @Override
    public String getType() {
        // Method
    }
}

// SensorFactory.java

public abstract class SensorFactory {
    public abstract Sensor createSensor(String sensorType, double reading);
}