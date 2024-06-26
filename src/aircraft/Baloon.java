package src.aircraft;

/**
 * The Baloon class represents a type of aircraft that is a Baloon.
 * It extends the Aircraft class and implements the updateConditions method to change its state based on the weather.
 */
public class Baloon extends Aircraft {
    /** Constructs a new Baloon object with the given id, name, and coordinates. */
    public Baloon (long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    /**
     * Updates the conditions of the Baloon based on the current weather.
     * This method retrieves the current weather from the WeatherTower and adjusts the Baloon's coordinates accordingly.
     * It also prints a weather-related message.
     */
    public void updateConditions() {

        String weather = super.weatherTower.getWeather(coordinates);
        String weatherMsg = super.weatherTower.getMsg(weather);

        // Adjust baloon's position and log message based on weather conditions
        switch (weather) {
            case ("SUN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case ("RAIN"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case ("FOG"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
            }
        System.out.println("Baloon#" + name + "(" + id + "): " + weatherMsg);
    }
}