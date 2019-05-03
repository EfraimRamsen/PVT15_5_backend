package projectfiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
/*
this is a class to fetch challenges created by users from the database and create challenge objects and return those objects
as a collection.

all comments wil be above to code it refers to


TO DO
fix the creation of the challenge object and add it to the challengeCollection.


IMPORTANT
do not forget to close statement or crash
do not forget to close connection or crash


written by Michel
 */


public class FetchChallengeFromDatabase {


    //SQL query to be executed
    private String sqlQuery = ("SELECT * FROM `Challenge`");
    private Connection con;
    private Statement stmt;
    //untab this when challenge object is complete.
 //   private Collection<Challenge> challengeCollection = new ArrayList<Challenge>();


    //constructor that also executes the retrival of data from the database.
    public FetchChallengeFromDatabase(){
        fetchDataFromDatabase();

    }
    private void fetchDataFromDatabase(){

        try{
            //this is the name of the driver that handels the connection to the database
            Class.forName("org.mariadb.jdbc.Driver");

            //this is the connection to the database. do not forget to close it
            con = DriverManager.getConnection("jdbc:mariadb://mysql.dsv.su.se:3306");

            //the statement is the query that will be asked to the database. do not forget to close it.
            stmt = con.createStatement();

            //the results from the query. the resultset is bound to the connection and statement and is only "alive" as long as
            //the connection is active. can only be iterated once.
            ResultSet rs = stmt.executeQuery(sqlQuery);


            // handles the data row by row by creating a challenge object and adds that object to the collection.
            while(rs.next()){
                String challengeName = rs.getString("ChallengeName");
                String challengeDesc = rs.getString("Description");
                int atLocationId = rs.getInt("WorkoutSpotID");
                int challengeID = rs.getInt("ChallengeID");
                int participants = rs.getInt("Participants");
                Time time = rs.getTime("Time");
                Date date = rs.getDate("Date");
                //untab these lines when challenge object is complete
 //               Challenge challenge = new Challenge();
 //               challengeCollection.add(challenge);
            }
        }catch
            //catching exceptions, dont know why printstacktrace...
        (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            //closing statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //closing connection
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //untab these lines when challenge object is completed.
//    public Collection getCollection(){
//        return challengeCollection;
//    }
}
