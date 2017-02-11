package by.casanova.team;

import by.casanova.team.config.persist.JpaConfig;
import by.casanova.team.dao.LabDao;
import by.casanova.team.models.labs.Lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DailylabsApplication {

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(DailylabsApplication.class, args);
	}
}
