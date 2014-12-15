package blog.rest;

import blog.domain.Article;
import blog.jms.myMessageCreator;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by jamesRMBP on 08/12/14.
 * this is the controller for all article rest services
 */
@Controller
@RequestMapping("/api/article")
public class ArticleRestController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    static String mailboxDestination = "mailbox-destination";

    @Autowired
    ConfigurableApplicationContext context;


    private Logger log = Logger.getLogger(ArticleRestController.class);

    /**
     * post an article by rest
     * @param article
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/restPostArticle", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<Article> ResponseToAPost(@RequestBody Article article,HttpServletRequest request , HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        //get data from jason
        String title = article.getTitle();

//        User user = article.getAuthor();
        String author = article.getUsername();
        String content = article.getContent();

        log.info(author);

        Article article1 = new Article();
        article1.setAuthor(userRepository.findUserByUsername(author));
        article1.setTime(new Date());
        article1.setTitle(title);
        article1.setContent(content);
        long articleID = articleRepository.save(article1).getId();
        log.info(articleRepository.count());
        log.info("get a article: " + title + "contenu : " + content);


        HttpHeaders headers = addAccessControllAllowOrigin();
        ResponseEntity<Article> entity = new ResponseEntity<Article>(headers, HttpStatus.OK);


        // Send a message to jms
        myMessageCreator messageCreator = new myMessageCreator(String.valueOf(articleID));

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send(mailboxDestination, messageCreator);



        return  entity;
    }

    private HttpHeaders addAccessControllAllowOrigin() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    /**
     * get all article
     * @return get all articles
     */
    @RequestMapping(value = "/getAllArticles", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> getAll() {
        return (List<Article>) articleRepository.findAll();
    }

    /**
     * post a article by
     * @return
     */
    @RequestMapping(value = "/restPostArticle")
    public
    @ResponseBody
    List<Article> postResult() {
        return (List<Article>) articleRepository.findAll();
    }

    /**
     * get article by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/getArticle/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Article getArticleById(@PathVariable long id) {
        return articleRepository.findOne(id);
    }

}
