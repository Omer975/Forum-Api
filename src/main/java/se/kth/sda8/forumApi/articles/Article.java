package se.kth.sda8.forumApi.articles;


import se.kth.sda8.forumApi.topics.Topic;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * An article has a title, a body, an authorName. Can be comment(s) and a list from Topic.
 * Article and Topic classes have a ManyToMany relationship.
 */
@Entity
public class Article {

    /**
     * id is a unique number in database. Spring generates it automatically
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    /**
     * Article have to have at least a "title"
     */
    @Column(nullable=false)
    private  String title;

    private String body;

    private String authorName;

    @ManyToMany
    private List<Topic> topics;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", body=" + body + ", authorName=" + authorName + "]";
    }

}
