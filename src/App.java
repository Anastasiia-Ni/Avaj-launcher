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

public class App {

    private static int count = 0;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WeatherTower weatherTower = new WeatherTower();
    private static AircraftFactory myFactory = AircraftFactory.getInstance();

    public static void main( String[] args ) {
        try {

            PrintStream outcome = new PrintStream(new FileOutputStream("simulation.txt"));
            System.setOut(outcome);
            System.setErr(outcome);
            
            if (args.length == 1) {
                FileReader parser = new FileReader(args[0]);
                parser.processFile();
                createAircrafts(parser.getContent());
                simulation();
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

    private static void createAircrafts(List<String> content) throws MyException {
        String number = content.get(0);
        
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

    public static void simulation () {
        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
            if (flyable.getCoordinates().getHeight() <= 0) {
                weatherTower.unregister(flyable);
            }
        }

        for (int i = 0; i < count; ++i) {
            weatherTower.changeWeather();
        }
    }
}