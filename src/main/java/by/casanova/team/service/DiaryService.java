package by.casanova.team.service;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Lab;
import by.casanova.team.models.user.User;

/**
 * Created by artifaqiq on 2/12/17.
 */
public interface DiaryService {
    Diary save(Diary diary);
    Diary cascadeSave(Diary diary);
    void delete(Diary diary);
    Diary update(Diary diary);
    Iterable<Diary> getAll();
    Diary getById(long id);
    Diary getLastModifiedDiary();
}
