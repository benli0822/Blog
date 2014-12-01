package blog.service;

import blog.domain.Article;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by JIN Benli on 01/12/14.
 */
@Component("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Override
    public Article findArticleByUserAndDate(long uid, Date date) {

    }

    @Override
    public Article createArticle(Article article) {
        return null;
    }

    @Override
    public Article readArticle(long aid) {
        return null;
    }

    @Override
    public Article updateArticle(long aid) {
        return null;
    }

    @Override
    public boolean removeArticle(long aid) {
        return false;
    }
}
