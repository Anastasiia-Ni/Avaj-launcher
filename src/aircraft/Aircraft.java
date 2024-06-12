package src.aircraft;
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