package blog.mvc;

import blog.domain.Article;
import blog.service.ArticleService;
import blog.service.repository.ArticleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by JIN Benli on 17/11/14.
 */
@Controller
public class HomeController {

    private Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = {"/", "/home"})
    public String home(Model model) {

        log.info("[HomeController: home], mapped by home");
        model.addAttribute("articles", articleService.listArticleOrderByTime());
        log.info(model);
        return "view/home";
    }

    @RequestMapping(value = "/article")
    public String simpelArticle(@RequestParam(value = "id", required = true) int aid, Model model) {
        Article article = articleRepository.findOne(Long.valueOf(aid));
        model.addAttribute("article", article);
        return "view/simpleArticle";
    }

}