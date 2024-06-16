import { Routes } from '@angular/router';
import { Pages } from './pages';

export const routes: Routes = [
  {
    path: Pages.DASHBOARD,
    loadComponent: () => import('../dashboard/dashboard.component').then(value => value.DashboardComponent)
  },
  {
    path: '',
    redirectTo: Pages.DASHBOARD, pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: Pages.DASHBOARD, pathMatch: 'full'
  }
];
