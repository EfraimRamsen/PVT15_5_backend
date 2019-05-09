package projectfiles;

/**
 * Inherits from Place
 */
public class OutdoorGym extends Place{
    private String description;

    public OutdoorGym(Location location, String name, int id, String description){
        super(location, name, id);
        this.description = description;

    }

    // used for testing
    @Override
    public String toString(){
        return "\nOutdoorGym toString: "+
                "\nName: "+ name +
                "\nLocation: "+ location;
    }
}
