package by.casanova.team.service.impl;

import by.casanova.team.models.labs.Subject;
import by.casanova.team.repository.SubjectRepository;
import by.casanova.team.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artifaqiq on 2/12/17.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.delete(id);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Iterable<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
