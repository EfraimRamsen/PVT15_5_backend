package se.su.dsv.pvt.helloworld;


import java.sql.*;
import java.util.Collection;

public class RetriveOutdoorGymsFromDatabase {


    /**MUST CLOSE CONNECTOR OR DB CRASH
     * MUST CLOSE STATEMENT OR SYSTEM CRASH
     * CANNOT RETURN RESULTLIST AS IT NULLS IF CONNECTION CLOSE
     *
     *
     * STILL TO DO
     * Class needs to create objects of Outdoorgyms and put them in a "list" and return that list when asked.
     * mariadb driver needs to be installed on project. and put in classpath.
     *
     * the fetch from user must be replaced with fetch from table outdoorGym that doesnt not exist yet.
     *
     *
     * WHAT THE CLASS DOES
     * this class fetches outdoorgyms locations from the database. puts those in a list and returns that list when asked.
     *
     *
     */
    private String sqlQuery = ("SELECT * FROM Workoutspot");
    private Statement stmt;
    private Connection con;
    private ResultSet result;
    //private Collection<OutdoorGym> outdoorGymCollection;


    public RetriveOutdoorGymsFromDatabase(){
        executeQuery();
    }

    private void executeQuery() {
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://mysql.dsv.su.se:3306/pasi2645", "pasi2645", "aijee1mau7Ip");
            stmt = con.createStatement();
            result = stmt.executeQuery(sqlQuery);

            //content in while must be replaced to create outdoorgyms and place in collection
            while (result.next()) {
                System.out.println("OK!");
                //insert creation of workoutspot, in this case outdoorgyms. to make system scalable create seperate table.

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                result.close();
                stmt.close();
                con.close();
            } catch (Exception e) {

            }


        }

        // OutdoorGyms must be created as a class.
        //   public Collection<OutdoorGyms> getCollection(){

//        return outdoorGymCollection;
//    }

    }
}



