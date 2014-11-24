package blog.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "view/home";
    }

    @RequestMapping("/simpleArticle")
    public String simpelArticle() {
        return "view/simpleArticle";
    }
}