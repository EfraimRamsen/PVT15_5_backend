package projectfiles;

/**
 * Inherits from Place
 */
public class OutdoorGym extends Place{

    boolean hasLights;

    public OutdoorGym(Location location, String name, boolean hasLights){
        super(location, name);
        this.hasLights = hasLights;
    }

    // used for testing
    @Override
    public String toString(){
        return "\nOutdoorGym toString: "+
                "\nName: "+ name +
                "\nLocation: "+ location;
    }
}
