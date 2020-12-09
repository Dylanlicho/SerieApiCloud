package masterIL.example.ConfigSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSpringBootApplication.class, args);
	}

}
