import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrieveFromDatabasePasi {

        private String sqlQuery;
        private ResultSet resultsToReturn;

        public RetrieveFromDatabasePasi(String sqlQuery){
            this.sqlQuery = sqlQuery;
            connectToPasi();
        }

        protected ResultSet connectToPasi() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://mysql.dsv.su.se:3306/pasi2645", "pasi2645", "aijee1mau7Ip");
                Statement stmt = con.createStatement();
                resultsToReturn = stmt.executeQuery(sqlQuery);


            } catch (Exception e) {
                System.out.print(e);
            }
            return resultsToReturn;
        }
    }