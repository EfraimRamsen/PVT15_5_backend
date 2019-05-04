package projectfiles;

/**
 * GPS coordinates
 */
public class Location {

    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    // used for testing
    @Override
    public String toString(){
        return x + ", " + y;
    }
}
