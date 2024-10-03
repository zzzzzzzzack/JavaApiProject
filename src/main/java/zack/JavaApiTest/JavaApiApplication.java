package zack.JavaApiTest;

import com.fasterxml.jackson.core.io.OutputDecorator;
import foor.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import zack.JavaApiTest.run.Location;
import zack.JavaApiTest.run.Run2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class JavaApiApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
		log.info("Java API is running Successfully!");
		log.info("Something Changed.");

//		This is now moved to a class so it could be reused
//		var welcomeMessage = new foor.WelcomeMessage();
//		System.out.println(welcomeMessage);
		WelcomeMessage welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getWelcomeMessage());

		System.out.println(reverseString(welcomeMessage.getWelcomeMessage()));

	}


	// making a command line runner here. This will run after the application has started and, more importantly
	// after the application context has been created. This is a container for all the beans in the system.
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run2 run = new Run2(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOORS);
			log.info("Run: " + run);
		};
	}

	// just testing copilot
	public static String reverseString(String input) {
		if (input == null) {
			return null;
		}
		return new StringBuilder(input).reverse().toString();
	}

}
