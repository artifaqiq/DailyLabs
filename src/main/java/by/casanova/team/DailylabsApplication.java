package by.casanova.team;

import by.casanova.team.models.labs.Diary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DailylabsApplication {

	public static void main(String[] args) {

		new ClassPathXmlApplicationContext("DailyLabsApplicationContext.xml");

		System.out.println("Hello");
		SpringApplication.run(DailylabsApplication.class, args);
	}
}
