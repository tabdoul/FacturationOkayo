import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article } from '../models/article';


@Injectable({
  providedIn: 'root',
})
export class ArticleService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8081/article';

  /**
   * Récupère tous les articles de l'API
   */
  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(this.apiUrl);
  }


  /**
   * Récupère un article spécifique par son ID
   * @param id ID de l'article
   */
  getArticleById(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.apiUrl}/${id}`);
  }

  /**
   * Crée un nouvel article
   * @param article Données du nouvel article
   */
  createArticle(article: Article): Observable<Article> {
    return this.http.post<Article>(`${this.apiUrl}/create`, article);
  }

  /**
   * Met à jour un article existant
   * @param id ID de l'article
   * @param article Données mises à jour
   */
  updateArticle(id: number, article: Article): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, article);
  }

  /**
   * Supprime un article
   * @param id ID de l'article à supprimer
   */
  deleteArticle(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
