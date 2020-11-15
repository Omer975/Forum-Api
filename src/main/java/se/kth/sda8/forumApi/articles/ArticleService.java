package se.kth.sda8.forumApi.articles;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    /**
     * Getting, saving, deleting articles from database
     */
    public List<Article> getAll(){
        return articleRepo.findAll();
    }

    public Optional <Article> getById(int articleId){
        return articleRepo.findById(articleId);
    }

    public Article save(Article newArticle) {
        return articleRepo.save(newArticle);
    }

    public void delete(Article article) {
        articleRepo.delete(article);
    }
}
