package blog.service.repository;

import blog.domain.Article;
import blog.domain.Category;
import blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by JIN Benli on 01/12/14.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    public List<Article> findArticleByAuthor(User author);

    public List<Article> findArticleByTime(Date time);

    //TODO should check
    public List<Article> findArticleByCategories(Category category);
}
