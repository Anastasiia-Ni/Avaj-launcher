package src.aircraft;

import src.tower.WeatherTower;

/**
 * Abstract class representing a flyable entity in the simulation.
 * Classes extending Flyable must implement specific methods and are managed by a WeatherTower.
 */
public abstract class Flyable {
    protected WeatherTower weatherTower; // The weather tower this flyable is registered with.

    /**
     * Abstract method to update conditions based on the current weather.
     * Subclasses must implement their specific behavior.
     */
    public abstract void updateConditions();

    /**
     * Registers this flyable with a specified weather tower.
     * Upon registration, this flyable is added to the tower's list of observers.
     */
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        p_tower.register(this);
    }

    /** Abstract methods to retrieve parametrs of the flyable. */
    public abstract long getId();
    public abstract String getName();
    public abstract Coordinates getCoordinates();
}