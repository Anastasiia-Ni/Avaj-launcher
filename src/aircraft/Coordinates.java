package src.aircraft;

/**
 * The Coordinates class represents a set of geographic coordinates with longitude, latitude, and height.
 */

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    /**
     * Constructs a new Coordinates object with the specified longitude, latitude, and height.
     * This constructor is package-private to restrict access to the factory method.
     */
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

    /**
     * Factory method for creating a new Coordinates object.
     * This method is used to bypass the package-private constructor.
     * Фабричный метод создания коорд для обхода приватного пакетного конструктора
     */

    public static Coordinates of(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }
}