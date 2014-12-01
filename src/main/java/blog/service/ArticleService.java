package blog.service;

import blog.domain.Article;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by JIN Benli on 01/12/14.
 */
public interface ArticleService {

    /* Find an article */
    public List<Article> findArticleByUserAndDate(long uid, Date date);

    /*Find all the articles by categories*/
    public Set<Article> findArticleByCategories(long cid);

    /* Article CRUD */

    //TODO maybe should add comments and users
    public Article createArticle(Article article);

    public Article readArticle(long aid);

    public Article updateArticle(long aid, HashMap<String, String> values);

    public void removeArticle(long aid);



}
