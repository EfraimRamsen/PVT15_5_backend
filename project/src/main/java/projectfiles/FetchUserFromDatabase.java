package projectfiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/*
this is a class to fetch the users from and create user objects that are stored in a collection and return that collection

TO DO
fix the creation of the User object. User class needs to be complete.

REMEBER
close connection or crash
close statement or crash

written by Michel
 */
public class FetchUserFromDatabase {

    private String sqlQuery = ("SELECT * FROM `User`");
    private Connection con;
    private Statement stmt;
    private Collection<User> userCollection = new ArrayList<User>();


    //constructor that also triggers method for dataretrival from database
    public FetchUserFromDatabase(){
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

            //handels the data row by row untill there are no more rows. takes the data and creates User objects and store
            //those objects in a collection.
            while(rs.next()){

                String userName = rs.getString("UserName");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email = rs.getString("E-Mail");

                //this must be fixed, efter User class is complete, proper construction
//                User user = new User();//TODO making a comment so the code runs /efraim
//                userCollection.add(user);

            }

            //catches exceptions. dont know why printstacktrace...
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //closing statement to prevent crash
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //closing connection to prevent crash
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //returns the collection
    public Collection getCollection(){
        return userCollection;
    }
}
