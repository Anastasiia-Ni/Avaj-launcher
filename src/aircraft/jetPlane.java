package src.aircraft;

import java.lang.reflect.Constructor;

/**
 * JetPlane class represents a type of aircraft specialized in handling weather conditions.
 * Extends Aircraft and implements specific behavior for updating conditions based on weather changes.
 */
public class JetPlane extends Aircraft {

    /** Constructor to initialize a new JetPlane object */
    public JetPlane (long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    /**
     * Updates the jet plane's conditions based on the current weather received from the weather tower.
     * Adjusts latitude and height based on specific weather conditions and logs corresponding messages.
     */
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String weatherMsg = weatherTower.getMsg(weather);

        // Adjust jet plane's position and log message based on weather conditions
        switch (weather) {
            case ("SUN"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case ("RAIN"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case ("FOG"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                break;
            }
        System.out.println("JetPlane#" + name + "(" + id + "): " + weatherMsg);
    }
}