package src.aircraft;

import src.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        p_tower.register(this);
    }

    public abstract long getId();
    public abstract String getName();
    public abstract Coordinates getCoordinates();
}