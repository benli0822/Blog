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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class UserController {

//    @Autowired
//    private ArticleService articleService;

    @Autowired
    private UserRepository userRepository;

    private Logger log = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/setting")
    public String setting(final User user, HttpServletRequest request, HttpSession session) {
        log.info("[UserController: setting], listing setting form");
        User theUser = userRepository.findUserByUsername(request.getRemoteUser());
        session.setAttribute("user", theUser);
        log.info(session.getAttribute("user"));
        return "view/userSetting";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, params = {"save"})
    public String update(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "view/userSetting";
        }
//        userService.updateUser(long uid, HashMap<String, String> values);
        model.clear();
        return "redirect:/setting";
    }
}
