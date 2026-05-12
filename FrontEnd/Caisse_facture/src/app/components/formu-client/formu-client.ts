import { Component, inject } from '@angular/core';
import { ClientService } from '../../services/client';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Client } from '../../models/client';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formu-client',
  standalone: true,
  imports: [CommonModule, FormsModule],   templateUrl: './formu-client.html',
  styleUrl: './formu-client.scss',
})
export class FormuClient {
  private clientService = inject(ClientService);
  private router = inject(Router);

  client: Client = {
    code_client: '',
    adresse_client: '',
    ville_client: '',
    cp_client: '',
  };
  loading = false;
  error = '';
  success = '';

  submitForm() {
    this.loading = true;
    this.clientService.createClient(this.client).subscribe({
      next: () => {
        this.success = 'Client créé avec succès';
        this.loading = false;
        this.router.navigate(['/clients']);
      },
      error: (err) => {
        this.error = 'Erreur lors de la création du client';
        this.loading = false;
        console.error(err);
      }
    });
  }
}
