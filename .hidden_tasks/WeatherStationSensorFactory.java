public class WeatherStationSensorFactory extends SensorFactory {
    @Override
    public Sensor createSensor(String sensorType, double reading) {
        switch (sensorType) {
            case "Temperature":
                return new TemperatureSensor(reading);
            case "Humidity":
                return new HumiditySensor(reading);
            default:
                throw new IllegalArgumentException("Unknown sensor type: " + sensorType);
        }
    }
}