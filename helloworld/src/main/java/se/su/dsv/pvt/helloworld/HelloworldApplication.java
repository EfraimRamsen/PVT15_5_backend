package se.su.dsv.pvt.helloworld;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication extends SpringBootServletInitializer {

    //Variabler för att testa lagring på servern (används i timeCalc-metoden
    long time = System.currentTimeMillis();
    String buildDate = java.time.LocalDateTime.now().toString();

    public static void main(String[] args) {

        SpringApplication.run(HelloworldApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HelloworldApplication.class);
    }

    @RestController
    public class HelloRestController{
        @CrossOrigin
        @RequestMapping("/sayHello")
        public String greeting(){
            return "Hello, it works!";

        }
    }

    //Jocke testar lagring på servern (har även lagt till en tids-variabel för att fixa det.
    @RestController
    public class checkTimeSinceBuild{
        @CrossOrigin
        @RequestMapping("/time")
        public String timeCalc(){

            long millisSinceBuild = System.currentTimeMillis() - time;
            String timeSinceBuild = calcMillisToTime(millisSinceBuild);


            return "The build was made: " + buildDate + ". \n Time since build is: " + timeSinceBuild;
        }

        //Gör om en long med millisekunder till en sträng med minuter och sekunder
        private String calcMillisToTime(long millis){

            long minutes = (millis / 1000) / 60;
            long seconds = (millis / 1000) % 60;

            return minutes + " minutes and " + seconds + " seconds ago.";
        }
    }

    // JSON-version av HelloWorld
	@RestController
	public class HelloJSONRestController{
		@CrossOrigin
		@RequestMapping(value = "/sayJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public StringResponse greeting(){
			StringResponse response = new StringResponse("test", "JD", "99");
			return response;
		}

		private class StringResponse {
			private String response;
			private String name;
			private String age;

			public StringResponse(String response, String name, String age) {
				this.response = response;
				this.name = name;
				this.age = age;
			}

			public String getResponse() {
				return response;
			}

			public void setResponse(String response) {
				this.response = response;
			}

			public String getName() {
				return name;
			}

            public void setName(String name) {
                this.name = name;
            }

            public String getAge() {
				return age;
			}

            public void setAge(String age) {
                this.age = age;
            }
        }
	}

	@RestController
	public class EfraimTesting{
		@CrossOrigin
		@RequestMapping(value = "/efraim", method = RequestMethod.GET, produces = "application/json")
		public String greeting(){
			return EfraimTestingPerson.class.toString();
		}
/*		public String parameters() {
			return name +
					"\n" +
					id +
					"\n" +
					location +
					"\n" +
					hasChallenge;
		}
		String name = "Efraim";
		int id = 881025;
		String location = "59.407428,17.945602";//G10:5
		boolean hasChallenge = false;*/
	}

	/**
	 * Funkade inte! Måste konvertera:
	 *
	 * HTTP Status 500 ? Internal Server Error
	 *
	 * Type Exception Report
	 *
	 * Message No converter found for return value of type: class se.su.dsv.pvt.helloworld.HelloworldApplication$EfraimTestingPerson
	 */
	public class EfraimTestingPerson{
    	public EfraimTestingPerson(String name, int age, String country){
    		super();
    		this.name = "Efraim";
    		this.age = 30;
    		this.country = "Swe";
	    }
    	private String name;
    	private int age;
    	private String country;

    	public String getName(){
    		return name;
	    }
	    public void setName(String name){
    		this.name = name;
    	}
    	public int getAge(){
    		return age;
		}
		public void setAge(int age){
    		this.age = age;
		}
		public String getCountry(){
    		return country;
		}
		public void setCountry(String country){
    		this.country = country;
		}
	}
}

