package projectfiles;

/**
 * Inherits from Place
 */
public class OutdoorGym extends Place{

    boolean hasLights;

    public OutdoorGym(Location location, String name, boolean hasLights){
        super(location, name);
        this.hasLights = hasLights; //TODO Finns inte i API, tror det bara var ett exempel på unikt värde för subklass i modelleringen /Efraim
    }

    // used for testing
    @Override
    public String toString(){
        return "\nOutdoorGym toString: "+
                "\nName: "+ name +
                "\nLocation: "+ location;
    }
}
