package projectfiles;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


/*
this is a class to handle the connection to a database. it takes a SQL query as input and creates a connection.
returns the result in a cachedrowset that will survive the connection.

Comments are above the code

REMEMBER
close connection or crash
close statement or crash

written by Michel
*/

public class ConnectionToPasiDB {
    private CachedRowSet crs;
    private String sqlQuery;

    public ConnectionToPasiDB(String sqlQuery) {
        this.sqlQuery = sqlQuery;

        try {
            //finds the driver
            Class.forName("org.mariadb.jdbc.Driver");
            //creates connection
            Connection con = DriverManager.getConnection("jdbc:mariadb://mysql.dsv.su.se:3306/pasi2645","pasi2645","aijee1mau7Ip");
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
    }
    //returning the results
    public CachedRowSet getResult(){
        return crs;
    }
}