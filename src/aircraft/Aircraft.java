package src.aircraft;

/**
 * The Aircraft class represents a generic aircraft and extends the Flyable class.
 * It contains common properties and methods that are shared among different types of aircraft.
 */

public class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void updateConditions() {}
}