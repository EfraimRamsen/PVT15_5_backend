package projectfiles;

import java.util.ArrayList;

public class User {

    String name;
    String userID;
    String password;
    ArrayList<Challenge> challangeParticipationList = new ArrayList<>();

    public User (String name, String userID, String password){
        this.name = name;
        this.userID = userID;
        this.password = password;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }
}
