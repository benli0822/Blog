package blog.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JIN Benli on 24/11/14.
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Article article;

    @OneToOne
    private User author;

    private String content;

    private Date time;

    protected Comment() {
    }

    public Comment(Article article, User author, String content) {
        this.article = article;
        this.author = author;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                '}';
    }
}
