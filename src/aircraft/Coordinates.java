package src.aircraft;
public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    // package-private constructor
    Coordinates (int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        if (longitude < 0) {
            longitude = Integer.MAX_VALUE + longitude;
        }
        this.longitude = longitude; 
    }

    public void setLatitude(int latitude) { 
        if (latitude < 0) {
            latitude = Integer.MAX_VALUE + latitude;
        }
        this.latitude = latitude; 
    }

    public void setHeight(int height) { 
        this.height = height > 100 ? 100 : height; 
    }

    // Фабричный метод создания коорд для обхода приватного пакетного конструктора
    public static Coordinates of(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }
}