package src.tower;

import src.aircraft.Coordinates;

/**
 * Singleton class providing weather conditions based on coordinates.
 * Implements the Singleton design pattern with a private constructor
 * and a static method to access the single instance.
 */
public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"}; // Array holding weather types.

    private static final WeatherProvider instance = new WeatherProvider(); // Singleton instance.
    
    /** Private constructor to prevent external instantiation. */
    private WeatherProvider() { }

    /** Returns the singleton instance of WeatherProvider. */
    public static WeatherProvider getInstance() {
        return instance;
    }

    /**
     * Generates current weather based on the provided coordinates.
     * Calculates a random index using coordinates and returns the corresponding weather type.
     */
    public String getCurrentWeather (Coordinates p_coordinate) {
        long generator = Math.abs(p_coordinate.getLongitude() - p_coordinate.getLongitude() + p_coordinate.getHeight());
        return weather[(int) generator % 4];
    }
}