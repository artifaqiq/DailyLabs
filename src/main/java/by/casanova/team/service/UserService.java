package by.casanova.team.service;

import by.casanova.team.models.user.User;

/**
 * Created by artifaqiq on 3/5/17.
 */
public interface UserService {

    public User getById(long id);
    public User save(User user);
    public boolean exists(String username);
    public User verifyUser(String username, String password);
    public User getByToken(String token);
    public User update(User user);
}
