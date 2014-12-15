package blog.mvc;

import blog.domain.User;
import blog.service.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jamesRMBP on 01/12/14.
 */
@Controller
public class RegisterController {

    private Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register")
    public String register(final User user) {
        return "view/register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST, params = {"register"})
    public String register(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/register";
        }

        userRepository.save(user);

        return "redirect:/";
    }


}
