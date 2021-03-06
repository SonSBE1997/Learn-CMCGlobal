import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/question' },
  { path: 'exam', pathMatch: 'full', redirectTo: '/exam' },
  { path: 'user', pathMatch: 'full', redirectTo: '/user' },
  { path: 'home', pathMatch: 'full', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
