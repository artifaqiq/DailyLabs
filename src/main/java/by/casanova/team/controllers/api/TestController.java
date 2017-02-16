package by.casanova.team.controllers.api;

import by.casanova.team.config.TestConfiguration;
import by.casanova.team.models.labs.Diary;
import by.casanova.team.service.DiaryService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DiaryService diaryService;

    @RequestMapping("/diary.json")
    public String getTestDiaryJson() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(diaryService.getLastModifiedDiary());
    }

    @RequestMapping(value = "/diary.json", method = RequestMethod.PUT)
    public ResponseEntity<?> putTestDiaryJson(@RequestBody String body) {
        Diary diary = null;
        try {
            diary = new Gson().fromJson(body, Diary.class);
        } catch (JsonSyntaxException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        diaryService.cascadeSave(diary);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @RequestMapping("/all")
    public String testAll() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(diaryService.getAll());

    }

}

