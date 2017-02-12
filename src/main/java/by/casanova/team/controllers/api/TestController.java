package by.casanova.team.controllers.api;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.labs.Lab;
import by.casanova.team.service.LabService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by artifaqiq on 2/7/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private LabService labService;

    @RequestMapping("/diary.json")
    public String getTestDiaryJson() {
        Diary testDiary = (Diary) new ClassPathXmlApplicationContext("DailyLabsApplicationContext.xml")
                .getBean("labsExample");

        return new Gson().toJson(testDiary);
    }

    @RequestMapping(value = "/diary.json", method = RequestMethod.PUT)
    public ResponseEntity<?> putTestDiaryJson(@RequestBody String body) {

        try {
            new Gson().fromJson(body, Diary.class);
        } catch (JsonSyntaxException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/test")
    public String test() {

        Lab lab = new Lab();
        lab.setDescription("Description");
        lab.setPassed(true);
        lab.setName("Name");

        labService.addLab(lab.clone());
        labService.addLab(lab.clone());
        labService.addLab(lab.clone());

        return labService.getAll().toString();
    }

}

