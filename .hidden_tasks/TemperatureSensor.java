public class TemperatureSensor implements Sensor {
    private double reading;
    
    public TemperatureSensor(double reading) {
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
        return "Temperature";
    }
}