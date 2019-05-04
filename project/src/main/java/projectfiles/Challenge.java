package projectfiles;

import java.util.Date;

/**
 * The Challenge that a user can create
 */
public class Challenge {
	private String name;
	private Date date = new Date();
	private String description; //TODO fixa den här

	Challenge(String name){
		this.name = name;


	}

	// used for testing
	@Override
	public String toString(){
		return "\nChallenge toString: "+
				"\nName: "+ name +
				"\nDate: "+ date;
	}
}
