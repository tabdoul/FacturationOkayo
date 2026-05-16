import { Component, signal, inject } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from './services/auth';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  private authService = inject(AuthService);
  protected readonly title = signal('Caisse_facture');
  showArticleMenu = false;
  showClientMenu = false;

  toggleArticleMenu() {
    this.showArticleMenu = !this.showArticleMenu;
  }

  toggleClientMenu() {
    this.showClientMenu = !this.showClientMenu;
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  logout() {
    this.authService.logout();
  }
}
