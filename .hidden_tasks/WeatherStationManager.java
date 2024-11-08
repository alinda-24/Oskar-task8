import java.util.List;
import java.util.ArrayList;

public class WeatherStationManager {
    private List<WeatherStation> weatherStations = new ArrayList<>();
    
    public void loadWeatherStations(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            WeatherStationSensorFactory factory = new WeatherStationSensorFactory();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4 && parts[0].equals("WeatherStation")) {
                    String location = parts[1];
                    String sensorType = parts[2];
                    try {
                        double reading = Double.parseDouble(parts[3]);
                        Sensor sensor = factory.createSensor(sensorType, reading);
                        WeatherStation station = new WeatherStation(location, sensor);
                        weatherStations.add(station);
                    } catch (NumberFormatException ex) {
                        System.err.println("Invalid reading in line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }
    
    public List<WeatherStation> getWeatherStations() {
        return weatherStations;
    }

    public void displayWeatherDataAndForecasts() {
        for (WeatherStation station : weatherStations) {
            System.out.println("Weather Station at " + station.getLocation());
            System.out.println("Sensor Type: " + station.getSensor().getType());
            if (station.getSensor() instanceof TemperatureSensor) {
                System.out.println("Temperature Reading: " + ((TemperatureSensor) station.getSensor()).getReading() + "°C");
            } else if (station.getSensor() instanceof HumiditySensor) {
                System.out.println("Humidity Reading: " + ((HumiditySensor) station.getSensor()).getReading() + "%");
            }
            station.calculateForecast();
            System.out.println();
        }
    }
}