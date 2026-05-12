import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client';
@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8081/clients';

  /**
   * Récupère tous les clients de l'API
   */
  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiUrl);
  }
  /**
   * créer un client
   * @param client Données du client à créer
   */
  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.apiUrl, client);
  }

  /**
   * Met à jour un client existant
   * @param id ID du client
   * @param client Données mises à jour
   */
  updateClient(id: number, client: Client): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, client);
  }

  /**
   * Supprime un client
   * @param id ID du client à supprimer
   */
  deleteClient(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
