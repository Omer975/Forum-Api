package se.kth.sda8.forumApi.comments;

import se.kth.sda8.forumApi.articles.Article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Comment class has id, body, authorName and Article. Comment and Article classes have a ManyToOne relationship.
 * Each article can have zero or more comments.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(nullable=false)
    private Article article;

    private String body;

    private String authorName;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Topic [id=" + id + ", body=" + body + ", authorName=" + authorName + "]";
    }


}