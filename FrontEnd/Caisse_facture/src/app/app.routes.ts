import { Client } from './models/client';
import { Routes, CanActivateFn } from '@angular/router';
import { ArticleListComponent } from './components/article-list/article-list';
import { ClientList } from './components/client-list/client-list';
import { FormuClient } from './components/formu-client/formu-client';
import { LoginComponent } from './components/login/login';
import { authGuard } from './services/auth-guard';

export const routes: Routes = [
   {path: 'login', component: LoginComponent },
   {path: 'articles', component: ArticleListComponent },
   {path  : 'clients', component : ClientList, canActivate: [authGuard]},
   {path : 'clients/ajouter', component : FormuClient, canActivate: [authGuard]},
   { path: '', canActivate: [authGuard], redirectTo: '', pathMatch: 'full' },
   { path: '**', redirectTo: 'login', pathMatch: 'full' }
  ];
