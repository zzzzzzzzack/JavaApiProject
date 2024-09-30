package zack.JavaApiTest;

import foor.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApiApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
		log.info("Java API is running Successfully!");

//		This is now moved to a class so it could be reused
//		var welcomeMessage = new foor.WelcomeMessage();
//		System.out.println(welcomeMessage);
		WelcomeMessage welcomeMessage = new WelcomeMessage();

	}

	// just testing copilot
	public static String reverseString(String input) {
		if (input == null) {
			return null;
		}
		return new StringBuilder(input).reverse().toString();
	}

}
