package projectfiles;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

/**
this is a class to handle the connection to a database. it takes a SQL query as input and creates a connection.
returns the result in a cachedrowset that will survive the connection.

Comments are above the code

REMEMBER
close connection or crash
close statement or crash

@author Michel
*/
public class ConnectionToPasiDB {

    private final String driverName = ("org.mariadb.jdbc.Driver");
    private final String urlName = ("jdbc:mariadb://mysql.dsv.su.se:3306/pasi2645");
    private final String databaseName = ("pasi2645");
    private final String password = ("aijee1mau7Ip");

    private String errorMessage;
    /*
    method for creating connection to retrive data, passes the cachedrowset to the databasemanagement class
     */
    public CachedRowSet getData(String sqlQuery) {
        CachedRowSet crs = null;
        try {
            //finds the driver
            Class.forName(driverName);
            //creates connection
            Connection con = DriverManager.getConnection(urlName, databaseName, password);
            //creates statement
            Statement stmt = con.createStatement();
            //primary result, will not survive closing of connection
            ResultSet rs = stmt.executeQuery(sqlQuery);
            //put into cachedrow... will survive closing of connection
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
            stmt.close();
            con.close();
            //handles errors, dont know why printStackTrace
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crs;
    }

    /*
    method for inserting data into the database returns a boolean, true if all ok, false if all not ok, also takes
    sql exception and stores in String, basiclly the error message to why and what went wrong.
     */

    public Boolean insertData(String sqlQuery) {
        boolean success = true;
        Exception e = null;
        try {
            //finds the driver
            Class.forName(driverName);
            //creates connection
            Connection con = DriverManager.getConnection(urlName, databaseName, password);
            //creates statement
            Statement stmt = con.createStatement();
            //execution of the statement. nothing gets returned as exception will be trown if something goes wrong
            stmt.executeQuery(sqlQuery);
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            success = false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //gets sqlexception into string
            errorMessage = ex.getMessage();
            success = false;
        }return success;
    }

    //method for retriving the error message if it is needed.
    public String getErrorMessage(){
        return errorMessage;
    }
}