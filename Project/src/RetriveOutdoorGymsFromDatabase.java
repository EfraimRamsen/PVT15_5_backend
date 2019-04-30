import java.sql.*;

public class RetriveOutdoorGymsFromDatabase {


    private String sqlQuery = ("SELECT * FROM User");


    private void executeQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql.dsv.su.se:3306/pasi2645", "pasi2645", "aijee1mau7Ip");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                System.out.println(result.getString("UserName") + ", " + result.getString("FirstName")
                        + " , " + result.getString("LastName") + " , " + result.getString("E-Mail "));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



