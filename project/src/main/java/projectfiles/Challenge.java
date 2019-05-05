package projectfiles;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Challenge that a user can create
 */
public class Challenge {
	private String name;
	private int numberOfParticipants;
	private String level; //TODO bestämma ifall det här ska vara en String eller kanske en egen klass?
    private String workoutType;
	private Date eventTimeAndDate = new Date(); //Valde att enbart göra en instans av datum och inte en separat för tid eftersom att tid finns inbyggt i datum-klassen
	private String description; //TODO fixa den här
    private ArrayList<User> participantList = new ArrayList<>();

	Challenge(String name, int numberOfParticipants, String level, String workoutType, Date eventTimeAndDate, String description){
		this.name = name;
		this.numberOfParticipants = numberOfParticipants;
		this.level = level;
		this.workoutType = workoutType;
		this.eventTimeAndDate = eventTimeAndDate;
		this.description = description;
	}

	// used for testing
	@Override
	public String toString(){
		return "\nChallenge toString: "+
				"\nName: "+ name +
				"\nDate: "+ eventTimeAndDate;
	}
}
