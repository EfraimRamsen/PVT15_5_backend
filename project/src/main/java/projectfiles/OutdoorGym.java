package projectfiles;

/**
 * Inherits from Place
 */
public class OutdoorGym extends Place{

    public OutdoorGym(Location location, String name){
        super(location, name);
    }

    // used for testing
    @Override
    public String toString(){
        return "\nOutdoorGym toString: "+
                "\nName: "+ name +
                "\nLocation: "+ location;
    }
}
