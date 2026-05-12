package com.okayo.facturation.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okayo.facturation.dtos.ArticleDTO;
import com.okayo.facturation.entities.Article;
import com.okayo.facturation.services.ArticleService;

@RestController
@RequestMapping("/article")
//@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {
    private final ArticleService articleService;
    public ArticleController(ArticleService articleService){ this.articleService=articleService; }

    @GetMapping
    public ResponseEntity<List<Article>> getAll(){
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public Optional<Article> getById(@PathVariable Integer id){
        return articleService.getArticleById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Article> create(@RequestBody ArticleDTO dto){
        Article a = articleService.createArticle(dto);
        return ResponseEntity.created(URI.create("/article/"+a.getId_article())).body(a);
    }
}