package by.casanova.team.service;

import by.casanova.team.models.labs.Lab;

/**
 * Created by artifaqiq on 2/12/17.
 */
public interface LabService {
    Lab save(Lab lab);
    void delete(long id);
    Lab update(Lab lab);
    Iterable<Lab> getAll();

}
