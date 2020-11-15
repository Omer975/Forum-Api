package se.kth.sda8.forumApi.comments;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepo extends JpaRepository<Comment, Integer>{

    List<Comment> findByArticle_id(int parseInt);
}
