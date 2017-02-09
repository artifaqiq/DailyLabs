package by.casanova.team.controllers.api;

import by.casanova.team.models.labs.Diary;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by artifaqiq on 2/7/17.
 */

@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/diary.json")
    public String getTestDiaryJson(HttpServletResponse response) {
        Diary testDiary = (Diary) new ClassPathXmlApplicationContext("DailyLabsApplicationContext.xml")
                .getBean("labsExample");

        response.setHeader("Access-Control-Allow-Origin", "*");
        return new Gson().toJson(testDiary);
    }

    @RequestMapping(value = "/diary.json", method = RequestMethod.PUT)
    public ResponseEntity<?> putTestDiaryJson(@RequestBody String body, HttpServletResponse response) {

        try {
            new Gson().fromJson(body, Diary.class);
        } catch (JsonSyntaxException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

