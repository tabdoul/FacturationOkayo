import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientService } from '../../services/client';
import { Client } from '../../models/client';

@Component({
  selector: 'app-client-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './client-list.html',
  styleUrl: './client-list.scss',
})
export class ClientList implements OnInit {
  private clientService = inject(ClientService);

  clients: Client[] = [];
  loading = true;
  error = '';

  ngOnInit() {
    this.clientService.getClients().subscribe({
      next: (data) => {
        this.clients = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des clients';
        this.loading = false;
        console.error(err);
      }
    });
  }

  deleteClient(id: number) {
    this.clientService.deleteClient(id).subscribe({
      next: () => {
        this.clients = this.clients.filter(c => c.id_Client !== id);
      },
      error: (err) => console.error(err)
    });
  }
}
