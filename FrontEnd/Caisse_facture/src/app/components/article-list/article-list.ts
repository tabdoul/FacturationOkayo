import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticleService } from '../../services/article';
import { Article } from '../../models/article';

@Component({
  selector: 'app-article-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './article-list.html',
  styleUrl: './article-list.scss'
})
export class ArticleListComponent implements OnInit {
  private articleService = inject(ArticleService);

  articles: Article[] = [];
  loading = true;
  error = '';

  ngOnInit() {
    this.articleService.getArticles().subscribe({
      next: (data) => {
        this.articles = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des articles';
        this.loading = false;
        console.error(err);
      }
    });
  }

  deleteArticle(id: number) {
    this.articleService.deleteArticle(id).subscribe({
      next: () => {
        this.articles = this.articles.filter(a => a.id_article !== id);
      },
      error: (err) => console.error(err)
    });
  }
}
