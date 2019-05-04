package projectfiles;

import java.util.Date;

public class Challenge {
	private String name;
	private Date date = new Date();

	Challenge(String name){
		this.name = name;


	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString(){
		return "\nChallenge toString: "+
				"\nName: "+ name +
				"\nDate: "+ date;
	}
}
