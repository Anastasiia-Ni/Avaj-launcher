package src.aircraft;

import src.aircraft.Aircraft;
import src.aircraft.Baloon;
import src.aircraft.jetPlane;
import src.aircraft.Helicopter;


// Singleton
public class AircraftFactory {
    private  static int id = 0;

    protected Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinate) {
        Flyable newAircraft = null;
        ++id;

        switch(p_type) {
            case ("Baloon"):
                newAircraft = new Baloon(id, p_name, p_coordinate);
                break;
            case ("Helicopter"):
                newAircraft = new Helicopter(id, p_name, p_coordinate);
                break;
            case ("JetPlane"):
                newAircraft = new jetPlane(id, p_name, p_coordinate);
                break;
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);


        }
        return newAircraft;
    }
}