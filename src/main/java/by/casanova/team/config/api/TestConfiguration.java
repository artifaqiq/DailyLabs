package by.casanova.team.config.api;

import by.casanova.team.models.labs.Lab;
import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artifaqiq on 2/8/17.
 */

@Configuration
public class TestConfiguration {

    @Bean
    public Diary labsExample() {

        Lab lab1 = new Lab();
        lab1.setName("1");
        lab1.setDescription("");
        lab1.setPassed(true);

        Lab lab2 = new Lab();
        lab2.setName("2");
        lab2.setDescription("Преподаватель сказал, что будет жестким");
        lab2.setPassed(false);

        Lab lab3 = new Lab();
        lab3.setName("Other name");
        lab3.setPassed(false);
        lab3.setDescription("");

        List<Lab> labs1 = new ArrayList<>();
        labs1.add(lab1);
        labs1.add(lab2);
        labs1.add(lab3);

        List<Lab> labs2 = new ArrayList<>();
        labs2.add(lab1);
        labs2.add(lab3);

        Subject subject1 = new Subject();
        subject1.setName("ТРиТПО");
        subject1.setDescription("Очень хороший преподователь");
        subject1.setLabs(labs1);

        Subject subject2 = new Subject();
        subject2.setName("СА");
        subject2.setDescription("");
        subject2.setLabs(labs2);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        Diary diary = new Diary();
        diary.setSubjects(subjects);

        return diary;
    }

}
