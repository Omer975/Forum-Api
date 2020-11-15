package se.kth.sda8.forumApi.articles;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda8.forumApi.topics.Topic;
import se.kth.sda8.forumApi.topics.TopicService;


/**
 * For control the article methods.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService topicService;


    public ArticleController(@Autowired ArticleService articleService) {
        this.articleService = articleService;
    }


    /**
     * Getting All articles
     */
    @GetMapping("/articles")
    public List<Article> getAll(@RequestParam(required=false) String topicId){

        if (topicId==null) {
            return articleService.getAll();
        }

        else {
            Optional<Topic> topic=topicService.getById(Integer.parseInt(topicId));
            return topic.orElse(new Topic()).getArticleList();
        }
    }

    /**
     * Getting articles by id
     */
    @GetMapping("/articles/{id}")
    public Article getById(@PathVariable int id){
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Create a new article
     */
    @PostMapping("/articles")
    public Article create(@RequestBody Article newArticle) {
        return articleService.save(newArticle);
    }

    /**
     * Update article
     */
    @PutMapping("/articles")
    public Article update(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * Delete article
     */
    @DeleteMapping("articles")
    public void deleteByArticle(@RequestBody Article article) {
        articleService.delete(article);
    }

}
