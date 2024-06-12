package src.aircraft;

public class jetPlane extends Aircraft {

    public jetPlane (long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String weatherMsg = weatherTower.getMsg(weather);

        switch (weather) {
            case ("SUN"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case ("RAIN"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case ("FOG"):
                this.coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                break;
            }
        System.out.println("JetPlane#" + name + "(" + id + "): " + weatherMsg);
    }
}