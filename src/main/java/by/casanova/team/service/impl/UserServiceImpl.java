package by.casanova.team.service.impl;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Subject;
import by.casanova.team.models.user.User;
import by.casanova.team.repository.DiaryRepository;
import by.casanova.team.repository.user.UserRepository;
import by.casanova.team.service.DiaryService;
import by.casanova.team.service.UserService;
import by.casanova.team.utils.auth.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by artifaqiq on 3/5/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiaryService diaryService;

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        user.setJwtToken(JwtUtils.createToken(user.getUsername(), new Random().nextLong()));
        Diary diary = new Diary();
        diary.setSubjects(new ArrayList<Subject>());
        diary = diaryService.cascadeSave(diary);
        user.setDiary(diary);
        return userRepository.save(user);
    }

    @Override
    public boolean exists(String username) {
        return userRepository.countUsersByUsername(username) == 1;
    }

    @Override
    public User verifyUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null || !user.getPassword().equals(password)) {
            return null;
        } else {
            return user;
        }
    }

}
