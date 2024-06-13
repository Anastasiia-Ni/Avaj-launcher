package src.tower;

import java.util.List;
import java.util.ArrayList;
import src.aircraft.Flyable;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    
    public void register(Flyable p_flyable) {
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.";
            System.out.println("Tower says: " + message);
        }
    }

    public void unregister(Flyable p_flyable) {
        if (observers.contains(p_flyable)) {
            observers.remove(p_flyable);
            String type = p_flyable.getClass().getSimpleName();
            String message = type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.";
            System.out.println("Tower says: " + message);
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