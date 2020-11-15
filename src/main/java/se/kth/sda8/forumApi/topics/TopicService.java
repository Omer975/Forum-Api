package se.kth.sda8.forumApi.topics;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda8.forumApi.articles.ArticleRepo;

@Service
public class TopicService {

    @Autowired
    TopicRepo topicRepo;
    @Autowired
    ArticleRepo articleRepo;

    /**
     * Getting, saving and listing topics from database
     */
    public List<Topic> getAll(){
        return topicRepo.findAll();
    }

    public Optional <Topic> getById(int topicId){
        return topicRepo.findById(topicId);
    }

    public Topic save(Topic newTopic) {
        return topicRepo.save(newTopic);
    }

    public void delete(Topic topic) {
        topicRepo.delete(topic);
    }

    public List<Topic> getAllByArticleId(int articleId) {
        return topicRepo.findByArticles_id(articleId);
    }
}
