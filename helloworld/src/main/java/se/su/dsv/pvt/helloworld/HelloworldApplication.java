package se.su.dsv.pvt.helloworld;

//@SpringBootApplication
//public class HelloworldApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(HelloworldApplication.class, args);
//	}
//
//	@RestController
//    public class helloRestController{
//	    @RequestMapping("/sayHello")
//        public String greeting(){
//	        return "Hello, it works!";
//
//        }
//
//    }
//
//}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloworldApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HelloworldApplication.class);
    }

//    	@RestController
//    public class helloRestController{
//	    @RequestMapping("/sayHello")
//        public String greeting(){
//	        return "Hello, it works!";
//
//        }
//    }
}

