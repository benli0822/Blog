package blog.mvc;

import blog.Application;
import blog.domain.Article;
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
public class BlogController {

//    @Autowired
//    private ArticleService articleService;

    @RequestMapping(value = "post")
    public String post() {
        return "view/post";
    }

    @RequestMapping(value = "post", method = RequestMethod.POST, params = {"save"})
    public String post(final Article article, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "view/post";
        }
//        articleService.createArticle(article);
        model.clear();
        return "redirect:/view/post";
    }
}
