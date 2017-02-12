package by.casanova.team.service;

import by.casanova.team.config.TestConfiguration;
import by.casanova.team.models.labs.Diary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by artifaqiq on 2/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaryServiceTests {
    @Autowired
    private DiaryService diaryService;

    @Test
    public void saveDiaryTest() {
        Diary diaryExample = new TestConfiguration().diaryExample();
        diaryExample = diaryService.save(diaryExample);

        System.out.println("Save diary: " + diaryExample);

    }

    @Test
    public void deleteDiaryByIdTest() {
        Iterable<Diary> diaries = diaryService.getAll();
        System.out.println("All diaries: " + diaries);

        Diary delDiary = diaries.iterator().next();
        diaryService.delete(delDiary.getId());
        System.out.println("Delete diary" + delDiary);

        diaries = diaryService.getAll();
        System.out.println("All diaries: " + diaries);
    }

    @Test
    public void updateDiaryTest() {

        Iterable<Diary> diaries = diaryService.getAll();
        System.out.println("All diaries: " + diaries);

        Diary updatedDiary = diaries.iterator().next();
        updatedDiary.getSubjects().get(0).setDescription("new test description");

        updatedDiary = diaryService.update(updatedDiary);
        System.out.println("Updated diary " + updatedDiary);

        diaries = diaryService.getAll();
        System.out.println("All diaries: " + diaries);
    }



}
