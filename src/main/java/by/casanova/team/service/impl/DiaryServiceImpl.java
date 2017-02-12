package by.casanova.team.service.impl;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Lab;
import by.casanova.team.models.labs.Subject;
import by.casanova.team.repository.DiaryRepository;
import by.casanova.team.repository.LabRepository;
import by.casanova.team.repository.SubjectRepository;
import by.casanova.team.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artifaqiq on 2/12/17.
 */
@Service
public class DiaryServiceImpl implements DiaryService{

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private LabRepository labRepository;

    @Override
    public Diary save(Diary diary) {

        Diary savedDiary = diaryRepository.save(diary);
        List<Subject> savedSubjects = new ArrayList<>();

        for(Subject subject : diary.getSubjects()) {
            subject.setDiary(savedDiary);
            savedSubjects.add(subjectRepository.save(subject));
        }

        for(Subject subject : savedSubjects) {
            for(Lab lab : subject.getLabs()) {
                lab.setSubject(subject);
                labRepository.save(lab);
            }
        }

        return savedDiary;
    }

    @Override
    public void delete(long id) {
        diaryRepository.delete(id);
    }

    @Override
    public Diary update(Diary diary) {
        return diaryRepository.save(diary);
    }

    @Override
    public Iterable<Diary> getAll() {
        return diaryRepository.findAll();
    }
}
