package src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.aircraft.AircraftFactory;
import src.aircraft.Coordinates;
import src.aircraft.Flyable;
import src.tower.WeatherTower;
import src.utils.FileReader;
import src.utils.MyException;
import src.utils.NumberChecker;

/**
 * The main class `App` orchestrates the aircraft simulation based on a scenario file.
 */
public class App {

    private static int count = 0; // Number of weather changes
    private static List<Flyable> flyables = new ArrayList<Flyable>(); // List of flyable objects
    private static WeatherTower weatherTower = new WeatherTower(); // Weather tower object
    private static AircraftFactory myFactory = AircraftFactory.getInstance(); // Singleton instance of AircraftFactory
    private static PrintStream originalOut = System.out;
    
    /** Main method: entry point of the application.  */
    public static void main( String[] args ) {
        try {            
            if (args.length == 1) {           
                FileReader parser = new FileReader(args[0]);
                parser.processFile();
                
                createAircrafts(parser.getContent());
                
                PrintStream outcome = new PrintStream(new FileOutputStream("simulation.txt"));
                System.out.println("Starting simulation...");
                System.setOut(outcome);

                simulation();
                
                System.setOut(originalOut);
                System.out.println("Simulation completed.");
            }
             else {
                System.out.println("Wrong number of arguments. One argument is expected: the file path.");
            }
        }
        catch (IOException e){
            System.out.println("Error processing file: " +  e.getMessage());
        }
        catch (MyException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /** Creates aircraft objects based on the parsed content from the scenario file. */
    private static void createAircrafts(List<String> content) throws MyException {
        String number = content.get(0); // First line of the content is the number of weather changes
        
        count = NumberChecker.parseNumber(number, 0);

        for (int i = 1; i < content.size(); ++i) {
            String[] line = content.get(i).split("\\s+");
            if (line.length != 5) {
                throw new MyException("Describes an aircraft error in line " + i);
            }

            List<String> validTypes = Arrays.asList("Baloon", "Helicopter", "Jetplane");
            String type = line[0].substring(0, 1).toUpperCase() + line[0].substring(1).toLowerCase();
            if (!validTypes.contains(type)) {
                throw new MyException("Aircraft name argument error in line " + i);
            }

            // Validating and parsing aircraft details
            int longitude = NumberChecker.parseNumber(line[2], i);
            int latitude = NumberChecker.parseNumber(line[3], i);
            int height = NumberChecker.parseNumber(line[4], i);
            if (height > 100) {
                height = 100;
            }

            Coordinates coordinate = Coordinates.of(longitude, latitude, height);
            flyables.add(myFactory.newAircraft(type, line[1], coordinate));
        }
    }

    /**
     * Starts the simulation by registering aircraft to the weather tower and triggering weather changes.
     */
    public static void simulation () {
        // Registering each flyable object to the weather tower
        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
            if (flyable.getCoordinates().getHeight() <= 0) {
                weatherTower.unregister(flyable);
            }
        }

        // Triggering weather changes for the specified number of times
        for (int i = 0; i < count; ++i) {
            weatherTower.changeWeather();
        }
    }
}