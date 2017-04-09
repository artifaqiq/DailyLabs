package by.casanova.team.config;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Lab;
import by.casanova.team.models.labs.Subject;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by artifaqiq on 2/8/17.
 */
@Configuration
public class TestConfiguration {

    public Diary diaryExample() {

        String randomDigit = String.valueOf(new Random().nextInt(5));

        Lab lab1 = new Lab();
        lab1.setName(randomDigit);
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

        ArrayList<Lab> labs1 = new ArrayList<>();
        labs1.add(lab1.clone());
        labs1.add(lab2.clone());
        labs1.add(lab3.clone());

        ArrayList<Lab> labs2 = new ArrayList<>();
        labs2.add(lab1.clone());
        labs2.add(lab3.clone());

        Subject subject1 = new Subject();
        subject1.setName("ТРиТПО");
        subject1.setDescription(randomDigit);
        subject1.setLabs((ArrayList) labs1.clone());

        Subject subject2 = new Subject();
        subject2.setName("СА");
        subject2.setDescription(randomDigit);
        subject2.setLabs(((ArrayList) labs2.clone()));

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(subject1.clone());
        subjects.add(subject2.clone());

        Diary diary = new Diary();
        diary.setSubjects((ArrayList) subjects.clone());

        return diary;
    }

}
