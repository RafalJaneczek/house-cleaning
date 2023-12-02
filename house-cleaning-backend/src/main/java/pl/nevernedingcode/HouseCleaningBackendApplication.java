package pl.nevernedingcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class HouseCleaningBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseCleaningBackendApplication.class, args);
    }

}
