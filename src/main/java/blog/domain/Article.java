package blog.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User author;

    @Size(max = 300)
    private String title;

    private Date time;

    private String username;

    @Size(max = 2000000)
    private String content;

    @ElementCollection
    private Set<String> images = new HashSet<String>();

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Category> categories = new HashSet<Category>();

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<Comment> comments = new HashSet<Comment>();


    public Article() {
        this.time = new Date();
    }

    public Article(User author, String title, Date time, String content, Set<String> images, Set<Category> categories, Set<Comment> comments) {
        this.author = author;
        this.title = title;
        this.time = new Date();
        this.content = content;
        this.images = images;
        this.categories = categories;
        this.comments = comments;
    }

    public Set<Comment> getComments() {
        return comments;
    }
    public void addComments(Comment comment){
        this.comments.add(comment);
    }
    public void setComments(Set<Comment> comments) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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