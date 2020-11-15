package se.kth.sda8.forumApi.topics;

import se.kth.sda8.forumApi.articles.Article;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Comment class has id, body, authorName and Article. Comment and Article classes have a ManyToOne relationship.
 * Each article can have zero or more comments.
 */
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String topicName;

    @ManyToMany
    private List<Article> articles;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Article> getArticleList() {
        return articles;
    }

    public void setArticleList(List<Article> articleList) {
        this.articles = articleList;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Topic [id=" + id + ", topicName=" + topicName + "]";
    }

}