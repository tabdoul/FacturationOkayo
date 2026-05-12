import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Facture } from '../models/facture';

@Injectable({
  providedIn: 'root',
})
export class FactureService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:5000/api/factures';

  /**
   * Récupère toutes les factures de l'API
   */
  getFactures(): Observable<Facture[]> {
    return this.http.get<Facture[]>(this.apiUrl);
  }

  /**
   * Récupère une facture spécifique par son ID
   */
  getFactureById(id: number): Observable<Facture> {
    return this.http.get<Facture>(`${this.apiUrl}/${id}`);
  }

  /**
   * Crée une nouvelle facture
   */
  createFacture(facture: Facture): Observable<Facture> {
    return this.http.post<Facture>(this.apiUrl, facture);
  }

  /**
   * Met à jour une facture existante
   */
  updateFacture(id: number, facture: Facture): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, facture);
  }

  /**
   * Supprime une facture
   */
  deleteFacture(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
