package blog.domain;


import javax.persistence.*;
import java.util.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User author;

    private String title;

    private Date time;

    private String content;

    @ElementCollection
    private Set<String> images = new HashSet<String>();

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Category> categories = new HashSet<Category>();

    @OneToMany(fetch=FetchType.LAZY)
    private Set<Comment> comments = new HashSet<Comment>();


    public Article() {
    }

    public Article(User author, String title, Date time, String content, Set<String> images, Set<Category> categories, Set<Comment> comments) {
        this.author = author;
        this.title = title;
        this.time = time;
        this.content = content;
        this.images = images;
        this.categories = categories;
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


    public boolean add(Category category) {
        return categories.add(category);
    }

    public boolean remove(Object o) {
        return categories.remove(o);
    }

    public void clear() {
        categories.clear();
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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