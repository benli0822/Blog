package blog.mvc;

import org.apache.log4j.Logger;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 11/12/14.
 */
@Controller
public class LoginController {

    private Logger log = Logger.getLogger(LoginController.class);

    private Facebook facebook;

    @RequestMapping(value = "/login")
    public String login() {
        return "view/login";
    }


    @RequestMapping(value = "/logout")
    public String logout() {
        if(facebook.isAuthorized()){

        }
        return "redirect:/login";
    }
}
