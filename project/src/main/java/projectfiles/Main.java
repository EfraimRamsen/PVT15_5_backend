package projectfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Main.class);
    }

    public static void main(String args[]) throws IOException, URISyntaxException {

        SpringApplication.run(Main.class, args);
/*
        DBManagement dbm = new DBManagement();
        String userName = ("nills");
        Collection<Challenge> challengeCollection = dbm.getAllChallenge();
*/
        //TEST FetchJSONFromAPI (Print all gyms)
//	    new FetchJSONFromAPI().parseFromAllOutdoorGyms();
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
