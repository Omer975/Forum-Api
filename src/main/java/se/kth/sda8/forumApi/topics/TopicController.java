package se.kth.sda8.forumApi.topics;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * Getting all topics
     */
    @GetMapping("/topics")
    public List<Topic> getAllByArticleId(@RequestParam(required=false) String articleId){
        if (articleId==null) {
            return topicService.getAll();
        }
        else {
            return topicService.getAllByArticleId(Integer.parseInt(articleId));
        }
    }

    /**
     * Create a new topic
     */
    @PostMapping("/topics")
    public Topic create(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    /**
     * Update a new topic
     */
    @PutMapping("/topics")
    public Topic update(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    /**
     * Delete a topic
     */
    @DeleteMapping("topics")
    public void delete(@RequestBody Topic topic) {
        topicService.delete(topic);
    }
}