package blog.service;

import blog.Application;
import blog.domain.Article;
import blog.domain.User;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JIN Benli on 01/12/14.
 */
@Component(value = "articleService")
@Import(Application.class)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    public ArticleRepository articleRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<Article> findArticleByUserAndDate(long uid, Date date) {
        User user = userRepository.findOne(uid);
        List<Article> articleList = articleRepository.findArticleByAuthor(user);

        for (Article a : articleList) {
            if (!a.getTime().equals(date)) {
                articleList.remove(a);
            }
        }
        return articleList;
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article readArticle(long aid) {
        return articleRepository.findOne(aid);
    }

    @Override
    public Article updateArticle(long aid, HashMap<String, String> values) {
        Article article = articleRepository.findOne(aid);

        for(String key : values.keySet()) {
            String value = values.get(key);

            if(key.equals("title") || key.equals("Title")) {
                article.setTitle(value);
            } else if (key.equals("content") || key.equals("Content")) {
                article.setContent(value);
            } else {
                //TODO Exception handler?
            }

        }
        return articleRepository.save(article);
    }

    @Override
    public void removeArticle(long aid) {
        articleRepository.delete(aid);
    }
}
