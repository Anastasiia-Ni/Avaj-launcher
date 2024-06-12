package src.tower;

import src.aircraft.Flyable;
import src.aircraft.Coordinates;
import src.utils.WeatherMsg;

public class WeatherTower extends Tower {
    public WeatherMsg weatherMsg = new WeatherMsg();
    
    public String getWeather(Coordinates p_coordinate) {
        return "SUN";
    }

    public void changeWeather() {

    }

    public void register(Flyable flyable) {
        // логика регистрации объекта
    }

    public String getMsg(String weather) {
        return this.weatherMsg.getRandomMsg(weather);
    }
}