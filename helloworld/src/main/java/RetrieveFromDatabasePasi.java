//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;


/**THIS CLASS IS TO BE DELETED!!!
 *
 *
 * THIS CLASS NEEDS TO BE REMADE. ONE CLASS FOR EACH TYP OCH QUERY TO EACH TABLE/TABLES.
 * MUST CLOSE CONNECTION OR DB CRASHES ON NEXT CONNECTION
 * MUST CLOSE STATEMENT BEFORE CONNECTION OR SYSTEM CRASH
 * CANNOT PASS RESULTSET, IS BOUND TO CONNECTION AND IF CONNECTION CLOSES RESULTSET IS SET TO NULL
 *
 *
 *   Class to retrive data from the database. takes a SQL query as input to the constructor and then establies a connection to
 *   the database. then runs the query and stores the results in a resultset that is returned
 *
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
 */