package se.kth.sda8.forumApi.articles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Integer>{

}