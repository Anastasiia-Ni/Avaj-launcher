package src.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String weatherMsg = weatherTower.getMsg(weather);

        switch (weather) {
            case ("SUN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case ("RAIN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case ("FOG"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
            }
        System.out.println("Helicopter#" + name + "(" + id + "): " + weatherMsg);
    }
}