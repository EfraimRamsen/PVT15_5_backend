package projectfiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


/*
this is a class to fetch outdoorgyms from database and create outdoorgym objects and return those objects in the
form of a collection

all comments will be above the code it refers to.

Remember!
close the statement otherwise crash!
close the connection otherwise crash!

written by Michel
 */


public class FetchOutdoorGymsFromDatabase {

    private String sqlQuery = "SELECT * FROM OutdoorGym, Workoutspot WHERE Workoutspot.WorkoutSpotId = OutdoorGym.WorkoutSpotId";

    private Connection con;
    private Statement stmt;
    private Collection<OutdoorGym> outdoorGymCollection = new ArrayList<OutdoorGym>();


    //the constructor that also fires the method to retrive the data from the database.
    public FetchOutdoorGymsFromDatabase() {
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {

        try {

            //this is the name of the driver that handels the connection to the database
            Class.forName("org.mariadb.jdbc.Driver");

            //this is the connection to the database. do not forget to close it
            con = DriverManager.getConnection("jdbc:mariadb://mysql.dsv.su.se:3306");

            //the statement is the query that will be asked to the database. do not forget to close it.
            stmt = con.createStatement();

            //the results from the query. the resultset is bound to the connection and statement and is only "alive" as long as
            //the connection is active. can only be iterated once.
            ResultSet rs = stmt.executeQuery(sqlQuery);


            //the handling of the data, row by row as long as there is more rows. gathers the information that we will put
            //in the outdoorgym objects and creates a location and an outdoorgym and puts that in a collection.
            while (rs.next()) {
                String gymName = rs.getString("WorkoutSpotName");
                int longitude = rs.getInt("Longitude");
                int latitude = rs.getInt("Latitude");
                boolean hasChallenge = rs.getBoolean("HasChallenge");
                String gymDesctiption = rs.getString("outdoorGymDesc");
                Location location = new Location(longitude, latitude);

                //as the gym class is not yet complete this line will have to change once it is.

                //toggle out once the outdoorgym class is complete and fix the code
 //               OutdoorGym outdoorGym = new OutdoorGym();
//                outdoorGymCollection.add(outdoorGym);

            }
        }
        catch

                //catching exceptions, dont know why printstacktrace...
        (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {

            //closing statement, this also closes the resultset
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            //closing the connection. efter this all info is in the collection.
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //passing the collection back to the place it is suppose to go
    public Collection getCollection(){
        return outdoorGymCollection;
    }
}

