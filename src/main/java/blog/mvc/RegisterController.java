package blog.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jamesRMBP on 01/12/14.
 */
@Controller
public class RegisterController {

    @RequestMapping(value = "/register")
    public String home() {
        return "view/register";
    }


}
