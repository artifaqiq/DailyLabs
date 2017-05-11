package by.casanova.team.service;

import by.casanova.team.models.labs.Diary;

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
