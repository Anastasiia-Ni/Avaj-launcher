package src.tower;

import src.aircraft.Flyable;
import src.aircraft.Coordinates;
import src.utils.WeatherMsg;

/**
 * Represents a weather tower that interacts with aircraft and provides weather updates.
 * Extends the Tower class to inherit registration and unregistration of Flyable objects.
 */
public class WeatherTower extends Tower {
    public WeatherMsg weatherMsg = new WeatherMsg(); // Instance of WeatherMsg for generating random weather messages.
    
    /** Singleton instance of WeatherProvider for weather generation. */
    WeatherProvider weatherProvider = WeatherProvider.getInstance(); 

    /** Retrieves the current weather based on the provided coordinates from WeatherProvider. */
    public String getWeather(Coordinates p_coordinate) {
        return this.weatherProvider.getCurrentWeather(p_coordinate);
    }

    /** Initiates a weather change by triggering the conditionChanged method. */
    public void changeWeather() {
        conditionChanged();
    }

    /** Registers a Flyable object to the WeatherTower. */
    public void register(Flyable flyable) {
        super.register(flyable);
    }

    /** Unregisters a Flyable object to the WeatherTower. */
    public void unregister(Flyable flyable) {
        super.unregister(flyable);
    }

    /**  Retrieves a random weather message based on the provided weather type. */
    public String getMsg(String weather) {
        return this.weatherMsg.getRandomMsg(weather);
    }
}