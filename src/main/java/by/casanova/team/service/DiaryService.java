package by.casanova.team.service;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Lab;

/**
 * Created by artifaqiq on 2/12/17.
 */
public interface DiaryService {
    Diary save(Diary diary);
    void delete(long id);
    Diary update(Diary diary);
    Iterable<Diary> getAll();
}
