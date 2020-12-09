package masterIL.example.DiscoverySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoverySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverySpringBootApplication.class, args);
	}

}
