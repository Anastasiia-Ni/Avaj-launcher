package src.aircraft;

import java.lang.reflect.Constructor;

/**
 * Helicopter class represents a type of aircraft specialized in handling weather conditions.
 * Extends Aircraft and implements specific behavior for updating conditions based on weather changes.
 */
public class Helicopter extends Aircraft {
    /** Constructor to initialize a new Helicopter object  */
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    /**
     * Updates the helicopter's conditions based on the current weather received from the weather tower.
     * Adjusts longitude and height based on specific weather conditions and logs corresponding messages.
     */
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String weatherMsg = weatherTower.getMsg(weather);

        // Adjust helicopter's position and log message based on weather conditions
        switch (weather) {
            case ("SUN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case ("RAIN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case ("FOG"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
            }
        System.out.println("Helicopter#" + name + "(" + id + "): " + weatherMsg);
    }
}