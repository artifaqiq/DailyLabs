package by.casanova.team.repository.user;

import by.casanova.team.models.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by artifaqiq on 3/5/17.
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    @Query("select count(1) from User u where u.username = ?1")
    public long countUsersByUsername(String username);

    @Query("select u from User u where u.username = ?1")
    public User findByUsername(String username);

    @Query("select u from User u where u.jwtToken = ?1")
    public User findByToken(String token);


}
