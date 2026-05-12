import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterLink,CommonModule],
  standalone: true,
  templateUrl: './app.html',
  styles: [`h1{color: blue ; text-align: center;}
    table {border-collapse: collapse; margin: 0 auto;}
    th, td {border: 1px solid #ddd; padding: 8px;}
    th {button {width: 100%; padding: 10px; font-size: 16px;}}`],
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('Caisse_facture');
  showArticleMenu = false;
  showClientMenu = false;
  showFormulaire = false;

  toggleArticleMenu() {
    this.showArticleMenu = !this.showArticleMenu;
  }
  toggleClientMenu() {
    this.showClientMenu = !this.showClientMenu;
  }
  toggleFormulaire() {
    this.showFormulaire = !this.showFormulaire;
}}
