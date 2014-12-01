package blog.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jamesRMBP on 01/12/14.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Article> articles = new HashSet<Article>();

    public Category(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
