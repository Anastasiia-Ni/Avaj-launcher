package src.tower;

import src.aircraft.Coordinates;

// Singleton - реализация . приватный конструктор и статический метод для доступа к единственному экземпляру
public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private static final WeatherProvider instance = new WeatherProvider();
    private WeatherProvider() { }

    public static WeatherProvider getInstance() {
        return instance;
    }

    public String getCurrentWeather (Coordinates p_coordinate) {
        long generator = Math.abs(p_coordinate.getLongitude() - p_coordinate.getLongitude() + p_coordinate.getHeight());
        return weather[(int) generator % 4];
    }
}