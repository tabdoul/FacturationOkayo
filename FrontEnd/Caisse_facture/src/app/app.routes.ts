import { Client } from './models/client';
import { Routes } from '@angular/router';
import { ArticleListComponent } from './components/article-list/article-list';
import { ClientList } from './components/client-list/client-list';
import { FormuClient } from './components/formu-client/formu-client';

export const routes: Routes = [
  { path: 'articles', component: ArticleListComponent },
   {path  : 'clients', component : ClientList},
   {path : 'clients/ajouter', component : FormuClient},
  ];
