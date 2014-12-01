package blog.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home() {
        return "view/home";
    }

    @RequestMapping(value = "/simpleArticle")
    public String simpelArticle() {
        return "view/simpleArticle";
    }

    @RequestMapping(value = "/setting")
    public String setting(){
        return "view/userSetting";
    }
}