package blog.mvc;

import blog.domain.Article;
import blog.domain.Comment;
import blog.domain.User;
import blog.service.ArticleService;
import blog.service.repository.ArticleRepository;
import blog.service.repository.CommentRepository;
import blog.service.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = {"/", "/home"})
    public String home(Model model) {

        log.info("[HomeController: home], mapped by home");
        model.addAttribute("articles", articleService.listArticleOrderByTime());
        log.info(model);
        return "view/home";
    }

    @RequestMapping(value = "/article")
    public String simpelArticle(final Comment comment, @RequestParam(value = "id", required = true) int aid, Model model) {
        Article article = articleRepository.findOne(Long.valueOf(aid));
        model.addAttribute("article", article);
        model.addAttribute("listComments", article.getComments());
        model.addAttribute("commentsListSize", article.getComments().size());

        return "view/simpleArticle";
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST, params = {"save"})
    public String simpelArticle(final Comment comment, @RequestParam(value = "id", required = true) int aid, final ModelMap model, final BindingResult bindingResult, HttpServletRequest req) {

        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "redirect:/home" ;
        }

        Article article = articleRepository.findOne(Long.valueOf(aid));
        log.info(article);
        log.info(aid);

        comment.setTime(new Date());

        User user  = userRepository.findUserByUsername(req.getRemoteUser());
        comment.setAuthor(user);
        article.addComments(comment);
        comment.setArticle(articleRepository.save(article));
        log.info(comment);
        commentRepository.save(comment);





        return "redirect:/article?id="+aid;
    }



}