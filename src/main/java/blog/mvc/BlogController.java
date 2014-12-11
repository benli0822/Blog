package blog.mvc;

import blog.Application;
import blog.domain.Article;
import blog.domain.Category;
import blog.domain.User;
import blog.service.ArticleService;
import blog.service.repository.CategoryRepository;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "post")
    public String post(final Article article, Model model, HttpSession session) {
        log.info("[BlogController: post], listing post form");
        List<User> adminList = userRepository.findUserByUsername("admin");
        User admin = adminList.get(0);
        session.setAttribute("admin", admin);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        log.info(session.getAttribute("admin"));
        log.info(model);
        return "view/post";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST, params = {"save"})
    public String post(final Article article, HttpSession session, final BindingResult bindingResult, final ModelMap model, HttpServletRequest req) {
        log.info("[BlogController: post], posting an article");
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/post";
        }
        List<String> categories = new ArrayList<String>();

        // get the keyword from http request
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if(entry.getKey().equals("keyWords")) {
                String[] keyWords = entry.getValue()[0].split(",");
                log.info(keyWords);
                categories = new ArrayList<String>(Arrays.asList(keyWords));
                log.info(categories);
            }
//            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }

        // now we will search if the category already existed, yes we add the dependency
        // in the article, no we will create a new category and do the same thing as previous
        if(!categories.isEmpty()) {
            for (String name : categories) {
                List<Category> query = categoryRepository.findCategoryByDescription(name);
                log.info(query);
                if(!query.isEmpty()) {
                    for(Category c : query) {
                        article.add(c);
                        c.addArticle(article);
                    }
                } else {
                    Category newCategory = new Category();
                    newCategory.setDescription(name);
                    newCategory.addArticle(article);
                    categoryRepository.save(newCategory);
                    article.add(categoryRepository.save(newCategory));
                    log.info(categoryRepository.findAll());
                }
            }
        }

        User admin = (User) session.getAttribute("admin");

        article.setAuthor(admin);
        log.info(article);
        log.info(article.getCategories());
        //TODO if category is new, the add it to article and add it to lib, if not, add dependency between category and article
        articleService.createArticle(article);
        model.clear();
        return "redirect:/home";
    }
}
