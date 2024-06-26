package src.aircraft;

/**
 * The AircraftFactory class is a singleton that provides a method to create instances of different types of aircraft.
 * It ensures that only one instance of the factory exists and provides eager initialization.
 */

public class AircraftFactory {
    private  static int id = 0;

    /** The singleton instance of AircraftFactory. */
    private static final AircraftFactory instance = new AircraftFactory();
    
    /**
     * Private constructor to prevent instantiation.
     * This is part of the Singleton design pattern.
     */
    private AircraftFactory() {}

    /** Returns the singleton instance of AircraftFactory. */
    public static AircraftFactory getInstance() {
        return instance;
    }

    /** Creates a new aircraft of the specified type with the given name and coordinates. */
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinate) {
        Flyable newAircraft = null;
        ++id;

        switch(p_type) {
            case ("Baloon"):
                newAircraft = new Baloon(id, p_name, p_coordinate);
                break;
            case ("Helicopter"):
                newAircraft = new Helicopter(id, p_name, p_coordinate);
                break;
            case ("Jetplane"):
                newAircraft = new JetPlane(id, p_name, p_coordinate);
                break;
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);


        }
        return newAircraft;
    }
}