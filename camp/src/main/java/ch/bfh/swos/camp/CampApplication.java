package ch.bfh.swos.camp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
public class CampApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}

}
