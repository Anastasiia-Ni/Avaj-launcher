package src.aircraft;

import src.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }


}