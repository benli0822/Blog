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
        session.setAttribute("theUser", theUser);
        user.setId(theUser.getId());
        user.setUsername(theUser.getUsername());
        user.setPassword(theUser.getPassword());
        user.setFirstname(theUser.getFirstname());
        user.setLastname(theUser.getLastname());
        user.setEmail(theUser.getEmail());
        user.setTwitter(theUser.getTwitter());
        user.setFacebook(theUser.getFacebook());
        log.info(session.getAttribute("theUser"));
        return "view/userSetting";
    }

    @RequestMapping(value = "/setting", method = RequestMethod.POST, params = {"save"})
    public String setting(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/userSetting";
        }
//        userService.updateUser(long uid, HashMap<String, String> values);
        model.clear();
        return "redirect:/setting";
    }
}
