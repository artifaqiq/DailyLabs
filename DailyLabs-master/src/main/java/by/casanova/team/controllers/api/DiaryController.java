package by.casanova.team.controllers.api;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.user.User;
import by.casanova.team.service.DiaryService;
import by.casanova.team.service.UserService;
import by.casanova.team.utils.ZonedDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by artifaqiq on 3/5/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class DiaryController {

    private UserService userService;

    private DiaryService diaryService;

    public DiaryController(@Autowired UserService userService, @Autowired DiaryService diaryService) {
        this.userService = userService;
        this.diaryService = diaryService;
    }

    @RequestMapping("/diary")
    public ResponseEntity<?> getDiaryJson(@RequestHeader(value = "Authorization") String authorization) {

        String token = authorization;
        User user = userService.getByToken(token);

        GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer());

        String json = gsonBuilder.create().toJson(user.getDiary(), Diary.class);
        return new ResponseEntity<>(json, HttpStatus.OK);

    }

    @RequestMapping(value = "/diary", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDiary(
            @RequestHeader(value = "Authorization") String authorization,
            @RequestBody String body) {

        Diary diary;

        User user = userService.getByToken(authorization);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        diary = gson.fromJson(body, Diary.class);

        diary.setLastModifiedDate(ZonedDateTime.now(ZoneOffset.UTC));

        diary = diaryService.cascadeSave(diary);
        user.setDiary(diary);
        userService.update(user);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
