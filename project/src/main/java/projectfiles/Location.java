package projectfiles;

/**
 * GPS coordinates
 */
public class Location {

    private int x;
    private int y;

    /**
     * Är väldigt osäker på ifall locationType faktiskt behövs eftersom informationen redan finns i Place
     * det kanske bara bidrar till att göra det krångligare att hantera att ha det här också?
     */
    private String locationType;

    public Location(int x, int y, String locationType){
        this.x = x;
        this.y = y;
        this.locationType = locationType;
    }

    public String getCoordinates() {
        return x + ", " + y;
    }

    // used for testing
    @Override
    public String toString(){
        return x + ", " + y;
    }
}
