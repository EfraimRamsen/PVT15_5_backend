package projectfiles;
/*
this is a class to handle all database management. instead of having to know every class that does one thing to the database
we got 1 class that has metods that does those things. one object to use methods on instead of 20 different classes to handle.

Comments are above the code it refers to

METHODS SO FAR
getAllChallenge
getOneChallenge
getAllOutdoorGyms
getOneOutdoorGym
getAllUsers
getOneUser


TO DO
getAllParticipations
getOneParticipation
addNewUser
addNewChallenge
addNewOutdoorGym
addNewParticipation

Written by Michel
 */


import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DBManagement {

    private CachedRowSet crs;
    private ConnectionToPasiDB ctpdb;
    /*
    a method to retrive all challenges from the database and return those challenges in the form of a collection
    will return empthy collection if no challenges exsists
     */
    public Collection getAllChallenge() {

        String sqlQuery = ("SELECT * FROM `Challenge`");
        Collection<Challenge> challengeCollection = new ArrayList<>();
        challengeCollection.clear();
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String challengeName = crs.getString("ChallengeName");
                String challengeDesc = crs.getString("Description");
                int atLocationId = crs.getInt("WorkoutSpotID");
                int challengeID = crs.getInt("ChallengeID");
                int participants = crs.getInt("Participants");
                Time time = crs.getTime("Time");
                Date date = crs.getDate("Date");

                //this is a testline only. delete once tested
                System.out.println(challengeName+challengeDesc+atLocationId);
                //TODO these lines when challenge object is complete with proper constructor
                //Challenge challenge = new Challenge();
                //challengeCollection.add(challenge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return challengeCollection;
    }

    /*
    a method to collect a single challenge from the database based on the challenge id nummer, creates that challenge and
    returns it
    will return null if challenge does not exsists
     */
    public Challenge getOneChallenge(int i) {
        String sqlQuery = ("SELECT " + i + " FROM `Challenge`");
        Challenge challenge = null;
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String challengeName = crs.getString("ChallengeName");
                String challengeDesc = crs.getString("Description");
                int atLocationId = crs.getInt("WorkoutSpotID");
                int challengeID = crs.getInt("ChallengeID");
                int participants = crs.getInt("Participants");
                Time time = crs.getTime("Time");
                Date date = crs.getDate("Date");
                //TODO challenge needs to be fixed with proper constructor
                //challenge = new Challenge();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (challenge != null) {
            return challenge;
        }else return null;
    }

    public Collection getAllOutdoorGyms() {


        /*
        a method to collect all outdoorGyms from the database and returns those objects as a collection
        will return empthy list if no outdoorgyms exsists
         */
        Collection<OutdoorGym> outdoorGymCollection = new ArrayList<>();
        outdoorGymCollection.clear();
        String sqlQuery = ("SELECT * FROM OutdoorGym, Workoutspot WHERE Workoutspot.WorkoutSpotId = OutdoorGym.WorkoutSpotId");
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String gymName = crs.getString("WorkoutSpotName");
                int longitude = crs.getInt("Longitude");
                int latitude = crs.getInt("Latitude");
                boolean hasChallenge = crs.getBoolean("HasChallenge");
                String gymDesctiption = crs.getString("outdoorGymDesc");
                Location location = new Location(longitude, latitude);
                boolean hasLights = true;
                OutdoorGym outdoorGym = new OutdoorGym(location, gymName, gymDesctiption);
                outdoorGymCollection.add(outdoorGym);
                //test line delete after testing
                System.out.println("ett outdoorGym object"+gymName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outdoorGymCollection;
    }

    /*
    this is a method to collect a single outdoorGym from the database and return that object
    will return null if outdoorgym does not exsists
     */
    public OutdoorGym getOneOutdoorGym (int i ){

        String sqlQuery = ("SELECT * FROM OutdoorGym, Workoutspot WHERE Workoutspot.WorkoutSpotId = OutdoorGym.WorkoutSpotId" +
                "AND OutdoorGymID = " + i);
        OutdoorGym outdoorGym = null;
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String gymName = crs.getString("WorkoutSpotName");
                int longitude = crs.getInt("Longitude");
                int latitude = crs.getInt("Latitude");
                boolean hasChallenge = crs.getBoolean("HasChallenge");
                String gymDesctiption = crs.getString("outdoorGymDesc");
                Location location = new Location(longitude, latitude);
                boolean hasLights = true;
                outdoorGym = new OutdoorGym(location, gymName, gymDesctiption);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (outdoorGym != null) {
            return outdoorGym;
        }else return null;
    }

    public Collection getAllUsers() {

        /*
        method to get all users from database and create user objects, and returns those objects in a colletion
        will return empthy collection if no users in database
         */
        String sqlQuery = ("SELECT * FROM `User`");
        Collection<User> userCollection = new ArrayList<>();
        userCollection.clear();

        try {

            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {

                String userName = crs.getString("UserName");
                String firstName = crs.getString("FirstName");
                String lastName = crs.getString("LastName");
                String email = crs.getString("E-Mail");

                //test line delete after testing
                System.out.println("ett challange object"+userName);

                //TODO user object needs fixing with firstName, lastName and E-Mail, password should not be stored in user object
                //User user = new User(userName, );
                //userCollection.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCollection;
    }

    /*
    a method to get a singel user from the database
    will return null if user does not exsists
     */
    public User getOneUser(String userNameInput){

        User user = null;
        String sqlQuery = ("SELECT "+userNameInput+" FROM User");
        try{
            crs = ctpdb.getData(sqlQuery);
            while(crs.next()){
                String userName = crs.getString("UserName");
                String firstName = crs.getString("FirstName");
                String lastName = crs.getString("LastName");
                String email = crs.getString("E-Mail");

                //TODO once User class is fixed, fix this
                //user = new User(userName, firstName, lastName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user!= null){
            return user;
        }else return null;
    }

}