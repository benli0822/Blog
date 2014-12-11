package blog.rest;

import blog.Application;
import blog.domain.Article;
import blog.domain.User;
import blog.service.UserService;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by jamesRMBP on 08/12/14.
 */
@Controller
@Import(Application.class)
public class ArticleRestController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    private Logger log = Logger.getLogger(ArticleRestController.class);

    @RequestMapping(value = "/api/restPostArticle", method = RequestMethod.POST)
    public
    @ResponseBody
    String ResponseToAPost(@RequestBody Article article,HttpServletRequest request) {

        //get data from jason
        String title = article.getTitle();

        User user = article.getAuthor();
        String author = article.getUsername();
        String content = article.getContent();


        Article article1 = new Article();
        article1.setAuthor(userRepository.findUserByUsername(author));
        article1.setTime(new Date());
        article1.setTitle(title);
        article1.setContent(content);

        articleRepository.save(article1);
        log.info(articleRepository.count());
        log.info("get a article: " + title + "contenu : " + content);

        //TODO add a reponse if the article is added to the DB
        return "redirect:/view/home";
    }

    @RequestMapping(value = "/api/getAllArticles", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> getAll() {
        return (List<Article>) articleRepository.findAll();
    }

    @RequestMapping(value = "/api/restPostArticle", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> postResult() {
        return (List<Article>) articleRepository.findAll();
    }

}
