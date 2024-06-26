package src.tower;

import java.util.List;
import java.util.ArrayList;
import src.aircraft.Flyable;


/**
 * Tower class manages the registration, unregistration, and notification of Flyable objects
 * as observers of weather changes.
 */
public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>(); // List to store registered Flyable observers.
    
    /** Registers a Flyable object as an observer to receive weather updates. */
    public void register(Flyable p_flyable) {
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.";
            System.out.println("Tower says: " + message);
        }
    }

    /** Unregisters a Flyable object from receiving further weather updates. */
    public void unregister(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.";
            System.out.println("Tower says: " + message);
        }
    }

    /**
     * Notifies all registered observers about weather condition changes.
     * Updates each observer's conditions and handles landing if altitude reaches or drops below zero.
     */
    protected void conditionChanged() {
        for (int i = 0; i < observers.size();) {
            observers.get(i).updateConditions();
            if (observers.get(i).getCoordinates().getHeight() <= 0) {
                unregister(observers.get(i));
            }
            else {
                ++i;
            }
        }
    }
}