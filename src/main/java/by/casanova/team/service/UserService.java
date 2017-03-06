package by.casanova.team.service;

import by.casanova.team.models.user.User;

/**
 * Created by artifaqiq on 3/5/17.
 */
public interface UserService {

    User getById(long id);
    User save(User user);
    boolean exists(String username);
    User verifyUser(String username, String password);
    User getByToken(String token);
    User update(User user);
}
