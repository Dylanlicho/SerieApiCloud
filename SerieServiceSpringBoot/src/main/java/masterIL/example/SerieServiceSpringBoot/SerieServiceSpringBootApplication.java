package masterIL.example.SerieServiceSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SerieServiceSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerieServiceSpringBootApplication.class, args);
	}

}
