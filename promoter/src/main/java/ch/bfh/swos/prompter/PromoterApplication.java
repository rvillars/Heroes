package ch.bfh.swos.prompter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class PromoterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromoterApplication.class, args);
	}

}
