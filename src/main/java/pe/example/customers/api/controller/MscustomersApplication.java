package pe.example.customers.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pe.compralo.customers")
public class MscustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscustomersApplication.class, args);
	}

}
