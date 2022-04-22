package modija.modija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModijaApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "h2");
        SpringApplication.run(ModijaApplication.class, args);
    }

}
