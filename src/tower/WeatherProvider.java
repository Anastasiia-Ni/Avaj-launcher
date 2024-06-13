package src.tower;

import java.util.Random;

import src.aircraft.Coordinates;

// Singleton - реализация . приватный конструктор и статический метод для доступа к единственному экземпляру
public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private static final WeatherProvider instance = new WeatherProvider();
    private WeatherProvider() { }

    public static WeatherProvider getInstance() {
        return instance;
    }

    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }

    public String getCurrentWeather (Coordinates p_coordinate) {
        int gen = p_coordinate.getLongitude();
        return weather[0];

    }
}