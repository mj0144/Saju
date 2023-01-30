package project.saju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SajuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SajuApplication.class, args);
    }

}
