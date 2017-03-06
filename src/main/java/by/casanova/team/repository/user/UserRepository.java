package by.casanova.team.repository.user;

import by.casanova.team.models.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by artifaqiq on 3/5/17.
 */

@Transactional
public interface UserRepository extends CrudRepository<User, Long>
{
    @Transactional
    @Query("select count(1) from User u where u.username = ?1")
    long countUsersByUsername(String username);

    @Transactional
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Transactional
    @Query("select u from User u where u.jwtToken = ?1")
    User findByToken(String token);

}
