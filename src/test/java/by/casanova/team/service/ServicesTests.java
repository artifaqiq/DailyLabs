package by.casanova.team.service;

import by.casanova.team.config.TestConfiguration;
import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artifaqiq on 2/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {
    @Autowired
    private DiaryService diaryService;

    @Test
    public void diaryServiceTest() {
        System.out.println("All: " + diaryService.getAll());

        Diary newDiary1 = new TestConfiguration().diaryExample();
        Diary newDiary2 = new TestConfiguration().diaryExample();

        System.out.println("New Diary #1: " + newDiary1);
        System.out.println("New Diary #2: " + newDiary2);

        Diary savedDiary1 = diaryService.cascadeSave(newDiary1);
        Diary savedDiary2 = diaryService.cascadeSave(newDiary2);

        System.out.println("Saved Diary #1: " + savedDiary1);
        System.out.println("Saved Diary #2: " + savedDiary2);

        Diary byIdDiary = diaryService.getById(savedDiary2.getId());
        System.out.println("Diary by id = " + savedDiary2.getId() + ": "+ byIdDiary);

        List<Subject> newSubjects = new ArrayList<>();
        Subject newSubject = new Subject();
        newSubject.setName("NEW NAME !!!");
        newSubjects.add(newSubject);
        byIdDiary.setSubjects(newSubjects);

        diaryService.delete(byIdDiary.getId());

        System.out.println("All: " + diaryService.getAll());

        System.out.println("Last modified: " + diaryService.getLastModifiedDiary());

    }

}
