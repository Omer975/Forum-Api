package se.kth.sda8.forumApi.topics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Integer> {

    List<Topic> findByArticles_id(int articleId);
}