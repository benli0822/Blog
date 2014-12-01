package blog.mvc;

import blog.Application;
import blog.service.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
@Import(Application.class)
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "view/home";
    }

    @RequestMapping(value = "/simpleArticle")
    public String simpelArticle() {
        return "view/simpleArticle";
    }

    @RequestMapping(value = "/setting")
    public String setting() {
        return "view/userSetting";
    }
}