package by.casanova.team.service;

import by.casanova.team.config.TestConfiguration;
import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Subject;
import by.casanova.team.models.user.User;
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

    @Autowired
    private UserService userService;

    @Test
    public void userServiceTest() {
        User newUser1 = new User();
        newUser1.setUsername("USERNAME");
        newUser1.setPassword("PASSWORD");
        newUser1.setEnabled(true);
        newUser1 = userService.save(newUser1);
        System.out.println("newUser = " + newUser1);

        System.out.println(userService.getById(newUser1.getId()));

        User newUser2 = new User();
        newUser2.setUsername("USERNAME");
        newUser2.setPassword("PASSWORD");
        newUser2.setEnabled(true);
        if(!userService.exists(newUser2.getUsername())) {
            newUser2 = userService.save(newUser2);
        }
        System.out.println("newUser = " + newUser2);

        System.out.println(userService.getById(newUser2.getId()));
    }

}
