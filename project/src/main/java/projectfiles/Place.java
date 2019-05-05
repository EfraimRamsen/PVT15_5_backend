package projectfiles;

import java.util.ArrayList;

/**
 * Abstract class
 */
public abstract class Place {
    Location location;
    String name;
    ArrayList<Challenge> challengeList = new ArrayList<>();

    public Place(Location location, String name){
        this.location = location;
        this.name = name;
    }

    public void addChallange(Challenge newChallenge){
        challengeList.add(newChallenge);
    }

    public ArrayList<Challenge> getChallengeList() {
        return challengeList;
    }
    public void removeChallenge(Challenge challenge){
        challengeList.remove(challenge);
    }
}
