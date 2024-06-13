package src.tower;

import src.aircraft.Flyable;
import src.aircraft.Coordinates;
import src.utils.WeatherMsg;

public class WeatherTower extends Tower {
    public WeatherMsg weatherMsg = new WeatherMsg();
    WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinates p_coordinate) {
        return this.weatherProvider.getCurrentWeather(p_coordinate);
    }

    public void changeWeather() {
        conditionChanged();
    }

    public void register(Flyable flyable) {
        super.register(flyable);
    }

    public void unregister(Flyable flyable) {
        super.unregister(flyable);
    }

    public String getMsg(String weather) {
        return this.weatherMsg.getRandomMsg(weather);
    }
}