package src.tower;

import java.util.List;
import java.util.ArrayList;
import src.aircraft.Flyable;


public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    
    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        String type = p_flyable.getClass().getSimpleName();
        System.out.println("Tower says: " + type + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower says: ");
    }

    protected void conditionChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}