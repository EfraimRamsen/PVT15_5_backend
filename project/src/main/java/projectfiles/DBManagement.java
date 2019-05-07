package projectfiles;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
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

@author Michel
 */


public class DBManagement {
    private String errorMessage;
    private CachedRowSet crs;
    private ConnectionToPasiDB ctpdb = new ConnectionToPasiDB();

    /**
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

                //TODO these lines when challenge object is complete with proper constructor
                //Challenge challenge = new Challenge();
                //challengeCollection.add(challenge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return challengeCollection;
    }

    /**
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
        } else return null;
    }

    public Collection getAllOutdoorGyms() {
        /**
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
                OutdoorGym outdoorGym = new OutdoorGym(location, gymName, gymDesctiption);
                outdoorGymCollection.add(outdoorGym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outdoorGymCollection;
    }

    /**
    this is a method to collect a single outdoorGym from the database and return that object
    will return null if outdoorgym does not exsists
     */
    public OutdoorGym getOneOutdoorGym(int i) {

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
                outdoorGym = new OutdoorGym(location, gymName, gymDesctiption);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (outdoorGym != null) {
            return outdoorGym;
        } else return null;
    }

    public Collection getAllUsers() {

        /**
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

                //TODO user object needs fixing with firstName, lastName and E-Mail, password should not be stored in user object
                //User user = new User(userName, );
                //userCollection.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCollection;
    }

    /**
    a method to get a singel user from the database
    will return null if user does not exsists
     */
    public User getOneUser(String userNameInput) {

        User user = null;
        String sqlQuery = ("SELECT " + userNameInput + " FROM User");
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
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
        if (user != null) {
            return user;
        } else return null;
    }

    /**
    this is a method to collect all participations from database, create participation object and return those object in
    a list.
    will return empty list if no participations are in database.
     */
    public Collection getAllParticipations() {
        String sqlQuery = ("SELECT * FROM Participation");
        //TODO once participation object has been created untab these
        //Participation participation;
        //Collection<> participationCollection = new ArrayList<>();
        //participationCollection.clear();

        //TODO delete this line onces the rest is fixed.
        //TODO change errorfix to georrect collection namned above
        Collection<String> errorfix = new ArrayList<>();
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String userName = crs.getString("UserName");
                int challengeID = crs.getInt("ChallengeID");

                //TODO create participation object
                //participation = new Participation(userName, challengeID);
                //participationCollection.add(participation)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO once participation exists fix this
        //return participationCollection;
        return errorfix;
    }

    /**
    this is a method for collection a single participation from the database, create a participation object and
    return that object.
*/
    /*
    TODO this method is currently not working as there is no participation class that object can be created off.
    public Participation getOneParticipation(String userName){
        Participation participation;
        String sqlQuery =("SELECT "+userName+" FROM participation");
        crs = ctpdb.getData(sqlQuery);
        while(crs.next()){
            String userName = crs.getString("UserName");
            int challengeID = crs.getInt("ChallengeID");
            participation = new Participation(userName,challengeID);
        }
        if(participation != null) {
            return participation;
        }else return null;
    }
    */

    /**
    this is a mthod used for the spring demo. can be used again if another demo is needed.
     */
    public String sprintDemo() {
        String sqlQuery = ("SELECT * FROM Challenge WHERE ChallengeID = 1");
        String message = null;
        try {
            crs = ctpdb.getData(sqlQuery);
            while (crs.next()) {
                String challengeName = crs.getString("ChallengeName");
                String challengeDesc = crs.getString("Description");
                int atLocationId = crs.getInt("WorkoutSpotID");
                int challengeID = crs.getInt("ChallengeID");
                int participants = crs.getInt("Participants");
                Date date = crs.getDate("Date");
                message = (challengeName + "\n" + challengeDesc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
    this is a method for adding a new user to the database. will return true and false depending on if the adding was
    successfull, if a fail it will automaticly retrive the errormessage and hold it if its needed.
     */
    public boolean addUser(String userName, String firstName, String lastName, String Email) {
        String sqlQuery = ("INSERT INTO User SET UserName = '" + userName + "', FirstName = '"
                + firstName + "', LastName = '" + lastName + "', Email ='" + Email + "'");
        boolean success = ctpdb.insertData(sqlQuery);
        if (!success) {
            errorMessage = ctpdb.getErrorMessage();
        }
        return success;
    }
    /**
    a method for forwarding the error message so it can be used if needed
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}