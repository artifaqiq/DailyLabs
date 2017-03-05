package by.casanova.team.controllers.api;

import by.casanova.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by artifaqiq on 3/5/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class DiaryController {

    @Autowired
    private UserService userService;


}
