package se.kth.sda8.forumApi.comments;

import java.util.List;

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

/**
 * For control the comment methods.
 */
@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Getting all comments
     *
     */
    @GetMapping("/comments")
    public List<Comment> getAll(@RequestParam(required=false) String articleId){
        if (articleId==null) {
            return commentService.getAll();
        }

        else {
            return commentService.getAllByArticleId(Integer.parseInt(articleId));
        }
    }

    /**
     * Getting comments by id
     */
    @GetMapping("/comments/{id}")
    public Comment getById(@PathVariable int id){
        return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Create a new comment
     */
    @PostMapping("/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    /**
     * Update comment
     */
    @PutMapping("/comments")
    public Comment update(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    /**
     * Delete comment
     */
    @DeleteMapping("comments")
    public void delete(@RequestBody Comment comment) {
        commentService.delete(comment);
    }

}