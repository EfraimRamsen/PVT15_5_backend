package projectfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String args[]) {


        DBManagement dbm = new DBManagement();
        boolean success = dbm.addUser("niilllls","testi","testu","tesslti@testuuri.com");
        if(success){
            System.out.println("user has been added");
        }if (!success){
            System.out.println(dbm.getErrorMessage());
        }



//spring demo code. delete after demo
        /*
        DBManagement dbm = new DBManagement();
        String message = dbm.sprintDemo();
        System.out.println(message);
*/

//this is code to test adding data to database, only to test, delete once done
        /*
DBManagement dbm = new DBManagement();
String userName = ("CarlaTheChallenger");
String firstName = ("Carla");
String lastName =("Espinosa");
String email = ("carlachallengercom");
boolean howDidItGo = dbm.addUser(userName,firstName,lastName,email);
if(howDidItGo){
    System.out.println(true);
}else System.out.println(false);
*/

        //TEST the Challenge class
        //Challenge testChallenge = new Challenge("testChallenge");
        //System.out.println(testChallenge.toString());
        //System.out.println();

        //TEST the FetchJSONfromAPI class
        //FetchJSONFromAPI fetch = new FetchJSONFromAPI();
        //Location location = new Location(fetch.getX(), fetch.getY());
        //OutdoorGym testAPIOutdoorGym = new OutdoorGym(location,fetch.getName());
        //System.out.println(testAPIOutdoorGym.toString());
    }
}

