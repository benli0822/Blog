package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

}