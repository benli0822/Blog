package blog.domain;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @NaturalId
    private User author;

    private String title;

    private String content;

    private HashSet<String> keyword;

    private Date time;

    @OneToMany(fetch=FetchType.LAZY)
    private List<Comment> comments;

    protected Article() {
    }

    public Article(User author, String title, String content, HashSet<String> keyword, Date time, List<Comment> comments) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.keyword = keyword;
        this.time = time;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(HashSet<String> keyword) {
        this.keyword = keyword;
    }

    public void addKeyword(String keyword) {
        this.keyword.add(keyword);
    }

    public void removeKeyword(String keyword) {
        this.keyword.remove(keyword);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}