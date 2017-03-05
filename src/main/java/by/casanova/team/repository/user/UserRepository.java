package by.casanova.team.repository.user;

import by.casanova.team.models.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by artifaqiq on 3/5/17.
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    @Query("select count(1) from User u where u.username = ?1")
    public long countUsersByUsername(String username);
}
