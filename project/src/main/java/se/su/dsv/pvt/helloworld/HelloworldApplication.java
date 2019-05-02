package se.su.dsv.pvt.helloworld;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class HelloworldApplication extends SpringBootServletInitializer {

    //Variabler för att testa lagring på servern (används i timeCalc-metoden
    long time = System.currentTimeMillis();
    String buildDate = java.time.LocalDateTime.now().toString();

    public static void main(String[] args) {

    	//Efraim testar:
	    GetUtegym getUtegym = new GetUtegym();
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
//
//			public void setResponse(String response) {
//				this.response = response;
//			}
//
			public String getName() {
				return name;
			}
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
            public String getAge() {
				return age;
			}
//
//            public void setAge(String age) {
//                this.age = age;
//            }
        }
	}


	@RestController
	public class EfraimTesting{
		@CrossOrigin
		@RequestMapping(value = "/gyms", method = RequestMethod.GET, produces = "application/json")
		public String listOfGyms(){
			String intro = "De utegym som finns i Stockholm är ";
			String gyms = "";

			return intro + " " +  gyms +".";
		}
	}
}

/**
 * Hämtar in JSON-objekt från en URL till Stockholm stads API. Läser in data från JSON-objektet till klassen Utegym.
 */
	class GetUtegym {
		private ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	public void getUtegym() throws IOException {
	URL url = new URL("http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/96a67da3-938b-487e-ac34-49b155cb277b/ServiceUnits/json?apikey=52f545a2957c4615a67ac2025ad9795f");

	Utegym utegym = objectMapper.readValue(url, Utegym.class);
		System.out.println("Namn = " + utegym.getName());
}

	}


	class Utegym{
		private String name = null;
		private String id = null;
		//lägg till fler attribut sen

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

/*
public class Car {
	private String brand = null;
	private int doors = 0;

	public String getBrand() { return this.brand; }
	public void   setBrand(String brand){ this.brand = brand;}

	public int  getDoors() { return this.doors; }
	public void setDoors (int doors) { this.doors = doors; }
}*/
