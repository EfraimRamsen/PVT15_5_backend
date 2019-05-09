package projectfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
import java.util.Iterator;

public class Main {

    public static void main(String args[]) throws IOException, URISyntaxException {


        DBManagement dbm = new DBManagement();
        String userName = ("nills");
        Collection<Challenge> challengeCollection = dbm.getAllChallenge();

        //TEST FetchJSONFromAPI (Print all gyms)
	    new FetchJSONFromAPI().parseFromAllOutdoorGyms();

    }

    @RestController
    public class HelloJSONRestController{
        @CrossOrigin
        @ResponseBody@RequestMapping(value = "/outdoorgym/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public OutdoorGym response(@RequestBody int gymID){

            int outdoorGymID = gymID;
            DBManagement dbm = new DBManagement();
            OutdoorGym gym = dbm.getOneOutdoorGym(outdoorGymID);

            return gym;
        }
    }


    /*
        long miliseconds = System.currentTimeMillis();
        Time time = new java.sql.Time(miliseconds);
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        DBManagement dbm = new DBManagement();
        boolean success = dbm.addChallenge("FITNESSSS", "grimsta!", time, date, 1);
        if (success) {
            System.out.println("challenge has been added");
        }
        if (!success) {
            System.out.println(dbm.getErrorMessage());


                    boolean success = dbm.addOutdoorGym("testGym", "fult gym!",
                314421 ,4214421  );
        if (success) {
            System.out.println("outdoorGym has been added");
        }
        if (!success) {
            System.out.println(dbm.getErrorMessage());
            */


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

//        TEST the FetchJSONfromAPI class
//        FetchJSONFromAPI fetch = new FetchJSONFromAPI("http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/96a67da3-938b-487e-ac34-49b155cb277b/ServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f");
//        Location location = new Location(fetch.getX(), fetch.getY());
//        OutdoorGym testAPIOutdoorGym = new OutdoorGym(location,fetch.getName(),false);
//        System.out.println(testAPIOutdoorGym.toString());
