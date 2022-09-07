package com.example.lg.service;

import com.example.lg.model.Article;
import com.example.lg.responsitory.ArticleResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleResponsitory articleResponsitory;

    public List<Article> getAllArticle(){
        return articleResponsitory.findAll();
    }


    public Page<Article> findPaginated(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return articleResponsitory.findAll(pageable);
    }

    public List<Article> searchArticle(String title){
        if(title !=null){
            return articleResponsitory.findArticleByTitleContains(title);
        }
        return articleResponsitory.findAll();
    }
    public Article findById(int id){
        return  articleResponsitory.findArticleByIdIs(id);
    }
    public Article update(Article article){
        return articleResponsitory.save(article);
    }
  //  public Page<Article> searchPaging(String title, Pageable pageable)
//    {
//        if(title !=null){
//            return articleResponsitory.findArticleByTitleContains(title,pageable);
//        }
//        return (Page<Article>) articleResponsitory.findAll();
//    }
}
