package src.tower;

import java.util.List;
import java.util.ArrayList;
import src.aircraft.Flyable;



public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    public void register(Flyable p_flyable) {
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.";
            System.out.println("Tower says: " + ANSI_YELLOW + message + ANSI_RESET);
        }
    }

    public void unregister(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.";
            System.out.println("Tower says: " + ANSI_PURPLE + message + ANSI_RESET);
        }
    }

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