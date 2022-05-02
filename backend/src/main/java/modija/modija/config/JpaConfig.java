package modija.modija.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"modija.modija.domain","modija.modija.repository"})
@EnableJpaRepositories("modija.modija.repository")
public class JpaConfig {
}
