package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}