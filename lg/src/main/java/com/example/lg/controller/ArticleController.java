package com.example.lg.controller;

import com.example.lg.model.Article;
import com.example.lg.responsitory.ArticleResponsitory;
import com.example.lg.service.ArticleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleResponsitory articleResponsitory;
    @GetMapping("/home")
    public String listAllArticle(Model model){
        return search("",model);
    }

    @GetMapping("/home/search")
    public String search(@RequestParam(value = "title") String title, Model model){
        System.out.println("title: "+ title);
        List<Article> list = articleService.searchArticle(title);
        if(list.isEmpty()){
            System.out.println("ko co gi");
        }
        model.addAttribute("list",list);
        model.addAttribute("title",title);
        return "home";
    }
    @GetMapping("/listcreator")
    public String listArticle(Model model){

        return findPaging(1,model);
    }

    @GetMapping("/listcreator/{pageNo1}")
    public String findPaging(@PathVariable(value = "pageNo1") int pageNo , Model model){
        int pageSize= 3;
        System.out.println("Page : "+pageNo);
        Page<Article> page =  articleService.findPaginated(pageNo,pageSize);
        List<Article> listA = page.getContent();
        model.addAttribute("pageNo" ,pageNo);
        model.addAttribute("total",page.getTotalPages());
        model.addAttribute("list",listA);
        return "listcreator";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id, Model model){
      articleResponsitory.deleteById(id);
        return "redirect:/listcreator";
    }
//    @GetMapping("/home/search/pageNo")
//    public String search1(@RequestParam(value = "title") String title, Model model,@RequestParam(value = "pageNo") Optional<Integer> pageNo){
//       int size= 2;
//       int no = pageNo.orElse(1);
//        Pageable pageable = PageRequest.of(no,size);
//        Page<Article> list = articleService.searchPaging(title,pageable);
//        if(list.isEmpty()){
//            System.out.println("ko co gi");
//        }
//        model.addAttribute("list",list);
//        model.addAttribute("title",title);
//        model.addAttribute("pageNo" ,pageNo);
//        model.addAttribute("total",list.getTotalPages());
//        return "home";
//    }

    @GetMapping("/update/{id}")
    public String updateAr(@PathVariable(name = "id") int id, Model model){
        System.out.println(articleService.findById(id));
        model.addAttribute("article",articleService.findById(id));
        return "update";
    }

    @PutMapping  ("/update")
    public String updateArticle(Model model,@ModelAttribute("article") Article article){
        article.setArticlecol("123");
        article.setUi(1);
        articleService.update(article);
        model.addAttribute("mess","update success");
        return "redirect:/listcreator";
    }
}
