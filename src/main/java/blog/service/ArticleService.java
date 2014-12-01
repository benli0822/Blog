package blog.service;

import blog.domain.Article;
import blog.domain.User;

import java.util.Date;

/**
 * Created by JIN Benli on 01/12/14.
 */
public interface ArticleService {

    /* Find an article */
    public Article findArticleByUserAndDate(long uid, Date date);


    /* Article CRUD */

    //TODO maybe should add comments
    public Article createArticle(Article article, User user);

    public Article readArticle(long aid);

    public Article updateArticle(long aid);

    public boolean removeArticle(long aid);

}
