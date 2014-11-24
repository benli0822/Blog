package blog.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String author;

    private String title;

    private String content;

    private Set<String> keyword;

    private Date time;

    @OneToMany(fetch=FetchType.LAZY)
    private List<Comment> comments;

    protected Article() {
    }

    public Article(String author, String title, String content, Set<String> keyword) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.keyword = keyword;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public void setKeyword(Set<String> keyword) {
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