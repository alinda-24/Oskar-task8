public class Main {
    public static void main(String[] args) {
        final String configFile = "weather_config.txt";
        WeatherStationManager manager = new WeatherStationManager();
        manager.loadWeatherStations(configFile);
        manager.displayWeatherDataAndForecasts();
    }
}