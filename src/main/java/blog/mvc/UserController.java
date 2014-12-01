package blog.mvc;

import blog.Application;
import blog.domain.User;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
@Import(Application.class)
public class UserController {

//    @Autowired
//    private ArticleService articleService;

    @RequestMapping(value = "update")
    public String update() {
        return "view/setting";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, params = {"save"})
    public String update(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "view/setting";
        }
//        userService.updateUser(long uid, HashMap<String, String> values);
        model.clear();
        return "redirect:/view/setting";
    }
}
