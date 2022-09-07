package com.example.lg.responsitory;

import com.example.lg.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleResponsitory extends JpaRepository<Article,Integer> {

    List<Article> findArticleByTitleContains(String title);
    //Page<Article> findArticleByTitleContains(String title, Pageable pageable);
    Article deleteArticleByIdContains(int id);
    Article findArticleByIdIs(int id);
}
