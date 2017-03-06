package by.casanova.team.repository;

import by.casanova.team.models.labs.Lab;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by artifaqiq on 2/12/17.
 */

@Transactional
public interface LabRepository extends CrudRepository<Lab, Long> {
}
