package projectfiles;

/**
 * Abstract class
 */
public abstract class Place {
    Location location;
    String name;

    public Place(Location location, String name){
        this.location = location;
        this.name = name;
    }

}
