package by.casanova.team.controllers.api;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.user.User;
import by.casanova.team.service.DiaryService;
import by.casanova.team.service.UserService;
import by.casanova.team.utils.ZonedDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by artifaqiq on 3/5/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class DiaryController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiaryService diaryService;

    @RequestMapping("/diary")
    public ResponseEntity<?> getDiaryJson(@RequestHeader(value = "Authorization") String authorization) {

        String token = authorization.split(" ")[1];
        User user = userService.getByToken(token);

        if (user == null) {
            return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
        } else {
            GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
            gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer());

            String json = gsonBuilder.create().toJson(user.getDiary(), Diary.class);
            return new ResponseEntity<Object>(json, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/diary", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDiary(@RequestBody String body,
                                         @RequestHeader(value = "Authorization") String authorization) {

        String token = authorization.split(" ")[1];
        User user = userService.getByToken(token);

        if (user == null) {
            return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
        } else {
            Diary diary;
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            diary = gson.fromJson(body, Diary.class);
            diary.setLastModifiedDate(ZonedDateTime.now(ZoneOffset.UTC));
            diary = diaryService.cascadeSave(diary);
            user.setDiary(diary);
            user = userService.update(user);

            return new ResponseEntity<Object>(HttpStatus.OK);
        }

    }

}
