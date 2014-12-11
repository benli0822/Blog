package blog.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 11/12/14.
 */
@Controller
public class LoginController {

    private Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public String login() {
        return "view/login";
    }
}
