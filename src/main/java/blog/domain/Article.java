package blog.domain;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Category> categories = new HashSet<Category>();

    private Date time;

    @OneToMany(fetch=FetchType.LAZY)
    private Set<Comment> comments;


    protected Article() {
    }

    public Article(User author, String title, String content, HashSet<String> keyword, Date time, Set<Comment> comments) {
        this.author = author;
        this.title = title;
        this.content = content;
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