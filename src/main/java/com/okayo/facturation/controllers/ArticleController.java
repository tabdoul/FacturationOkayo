package com.okayo.facturation.controllers;

import com.okayo.facturation.dtos.ArticleDTO;
import com.okayo.facturation.entities.Article;
import com.okayo.facturation.services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
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