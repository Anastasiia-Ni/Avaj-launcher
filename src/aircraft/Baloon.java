package src.aircraft;

public class Baloon extends Aircraft {
    public Baloon (long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {

        String weather = super.weatherTower.getWeather(coordinates);
        String weatherMsg = super.weatherTower.getMsg(weather);

        switch (weather) {
            case ("SUN"):
                this.coordinates.setLongitude(coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case ("RAIN"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case ("FOG"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case ("SNOW"):
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
            }
        System.out.println("Baloon#" + name + "(" + id + "): " + weatherMsg);
    }
}