package by.casanova.team.repository;

import by.casanova.team.models.labs.Subject;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by artifaqiq on 2/12/17.
 */

@Transactional
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
