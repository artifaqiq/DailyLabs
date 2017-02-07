package by.casanova.team.controllers.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by artifaqiq on 2/7/17.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping("/subjects")
    public String test(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        return "test";
    }

}

