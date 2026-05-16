import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from './auth';

export const authGuard: CanActivateFn = () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (authService.isLoggedIn()) {
    return true;  // ✅ connecté → accès autorisé
  }

  router.navigate(['/login']);  // ❌ non connecté → redirige vers login
  return false;
};
