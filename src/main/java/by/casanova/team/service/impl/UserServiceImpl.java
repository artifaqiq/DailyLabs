package by.casanova.team.service.impl;

import by.casanova.team.models.user.User;
import by.casanova.team.repository.user.UserRepository;
import by.casanova.team.service.UserService;
import by.casanova.team.utils.auth.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by artifaqiq on 3/5/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        user.setJwtToken(JwtUtils.createToken(user.getId(), user.getUsername(),
                new Random().nextLong()));
        return userRepository.save(user);
    }

    @Override
    public boolean exists(String username) {
        return userRepository.countUsersByUsername(username) == 1;
    }

}
