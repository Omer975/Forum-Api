package se.kth.sda8.forumApi.comments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Getting, saving, updating, deleting and listing comments from database
 */

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public List<Comment> getAll(){
        return commentRepo.findAll();
    }

    public Optional <Comment> getById(int commentId){
        return commentRepo.findById(commentId);
    }

    public Comment save(Comment newComment) {
        return commentRepo.save(newComment);
    }

    public void delete(Comment comment) {
        commentRepo.delete(comment);
    }

    public List<Comment> getAllByArticleId(int parseInt) {
        return commentRepo.findByArticle_id(parseInt);
    }
}


