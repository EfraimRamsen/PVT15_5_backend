package se.su.dsv.pvt.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication extends SpringBootServletInitializer {
    long time = System.currentTimeMillis();

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

            long timeSinceBuild = time - System.currentTimeMillis();
            return "The build was made: " + time + ". \n Time since build is: " + timeSinceBuild;

        }
    }

    // JSON-version av HelloWorld
	@RestController
	public class HelloJSONRestController{
		@CrossOrigin
		@RequestMapping(value = "/sayJSON", method = RequestMethod.GET, produces = "application/json")
		public String greeting(){
			StringResponse response = new StringResponse("JSON fungerar");
			return response.getResponse();
		}

		private class StringResponse {
			private String response;
			public StringResponse(String response) {
				this.response = response;
			}

			public String getResponse() {
				return response;
			}

			public void setResponse(String response) {
				this.response = response;
			}
		}
	}

	@RestController
	public class EfraimTesting{
		@CrossOrigin
		@RequestMapping("/efraim")
		public String parameters() {
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
		boolean hasChallenge = false;
	}
}

