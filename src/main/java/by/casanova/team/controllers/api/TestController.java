package by.casanova.team.controllers.api;

import by.casanova.team.models.labs.Diary;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

/**
 * Created by artifaqiq on 2/7/17.
 */

@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/diary.json")
    public String getTestDiaryJson() {
        Diary testDiary = (Diary) new ClassPathXmlApplicationContext("DailyLabsApplicationContext.xml")
                .getBean("labsExample");

        return new Gson().toJson(testDiary);
    }

    @RequestMapping(value = "/diary.json", method = RequestMethod.PUT)
    public String putTestDiaryJson() {
        //TODO
        return null;
    }

}

