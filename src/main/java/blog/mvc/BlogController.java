package blog.mvc;

import blog.Application;
import blog.domain.Article;
import blog.domain.User;
import blog.service.ArticleService;
import blog.service.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
@Import(Application.class)
public class BlogController {

    private Logger log = Logger.getLogger(BlogController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "post")
    public String post(final Article article, Model model, HttpSession session) {
        log.info("[BlogController: post], listing post form");
        List<User> adminList = userRepository.findUserByUsername("admin");
        User admin = adminList.get(0);
        session.setAttribute("admin", admin);
        model.addAttribute("users", userRepository.findAll());
        log.info(session.getAttribute("admin"));
        log.info(model);
        return "view/post";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST, params = {"save"})
    public String post(final Article article, HttpSession session, final BindingResult bindingResult, final ModelMap model) {
        log.info("[BlogController: post], posting an article");
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/post";
        }

        User admin = (User) session.getAttribute("admin");

        article.setAuthor(admin);
        articleService.createArticle(article);
        model.clear();
        return "redirect:/home";
    }
}
