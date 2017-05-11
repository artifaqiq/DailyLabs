package by.casanova.team.service;

import by.casanova.team.models.labs.Subject;

/**
 * Created by artifaqiq on 2/12/17.
 */
public interface SubjectService {
    Subject addSubject(Subject subject);
    void delete(long id);
    Subject update(Subject subject);
    Iterable<Subject> getAll();
}
