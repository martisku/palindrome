package no.sku.palindrome;

import no.sku.controllers.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackageClasses = PersonController.class)
public class PalindromeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalindromeApplication.class, args);
	}

}
