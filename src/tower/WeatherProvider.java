package src.tower;

// Singleton - реализация . приватный конструктор и статический метод для доступа к единственному экземпляру
public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() { }

    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }

    // public String getCurrentWeather (Coordinates p_coordinate) {   // +

    // }
}