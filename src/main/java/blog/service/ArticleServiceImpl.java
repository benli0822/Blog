package blog.service;

import blog.Application;
import blog.domain.Article;
import blog.domain.User;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by JIN Benli on 01/12/14.
 */
@Component(value = "articleService")
@Import(Application.class)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

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


    @Override
    public List<Article> listArticleOrderByTime() {
        List<Article> articles = (List<Article>)articleRepository.findAll();

        Collections.sort(articles, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                if (o1.getTime() == null || o2.getTime() == null)
                    return 0;
                return o1.getTime().compareTo(o2.getTime());
            }
        });

        return articles;
    }
}
