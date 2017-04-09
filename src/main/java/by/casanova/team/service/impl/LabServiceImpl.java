package by.casanova.team.service.impl;

import by.casanova.team.models.labs.Lab;
import by.casanova.team.repository.LabRepository;
import by.casanova.team.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artifaqiq on 2/12/17.
 */
@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabRepository labRepository;

    @Override
    public Lab save(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public void delete(long id) {
        labRepository.delete(id);
    }

    @Override
    public Lab update(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public Iterable<Lab> getAll() {
        return labRepository.findAll();
    }
}
