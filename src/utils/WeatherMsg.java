package src.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * WeatherMsg class provides random messages associated with different weather types.
 */
public class WeatherMsg {
    private Map<String, List<String>> weatherMessages;

    /** Constructor to initialize the WeatherMsg object and populate weather messages. */
    public WeatherMsg() {
        this.weatherMessages = new HashMap<>();
        initWeatherMessages();
    }

    /** Initializes weather messages for different weather types. */
    public void initWeatherMessages() {
        // Initialize messages for RAIN weather type
        weatherMessages.put("RAIN", new ArrayList<>(List.of(
            "Damn you rain! You messed up my aircraft.",
            "It's raining. Better keep the electronics dry.",
            "It's raining. Better watch out for lightings.",
            "Raindrops keep falling on my head, my flight is delayed again."
        )));
        // Initialize messages for FOG weather type
        weatherMessages.put("FOG", new ArrayList<>(List.of(
            "Foggy conditions. Keep an eye on the instruments.",
            "So foggy today! Can't see a thing.",
            "The fog is thick as pea soup today.",
            "Visibility is near zero, better slow down."
        )));
        // Initialize messages for SUN weather type
        weatherMessages.put("SUN", new ArrayList<>(List.of(
            "Let's enjoy the good weather and take some pics.",
            "What a sunny day, perfect for flying.",
            "This is hot.",
            "Sunshine all around makes it a great day to be up high!"
        )));
        // Initialize messages for SNOW weather type
        weatherMessages.put("SNOW", new ArrayList<>(List.of(
            "It's snowing. We're gonna crash.",
            "Watch out for ice on the wings.",
            "My rotor is going to freeze!",
            "OMG! Winter is coming!"
        )));
    }

    /** Retrieves a random message associated with the given weather type. */
    public String getRandomMsg(String weatherType) {
        List<String> messages = weatherMessages.get(weatherType);
        if (messages == null || messages.isEmpty()) {
            return "No messages available for this weather type.";
        }
        return messages.get(new Random().nextInt(messages.size()));
    }
}