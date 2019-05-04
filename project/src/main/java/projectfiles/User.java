package projectfiles;

public class User {

    String name;
    String password;

    public User (String name, String password){
        this.name = name;
        this.password = password;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }
}
