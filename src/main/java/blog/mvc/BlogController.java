package blog.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class BlogController {

    @RequestMapping("post")
    public String post() {
        return "view/post";
    }
}
