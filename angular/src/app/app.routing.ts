import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { LoginComponent } from './login/index';
import { KompetenzpflegeComponent } from './kompetenzpflege/kompetenzpflege.component'
import { ProfilComponent } from './profil/profil.component'
import { KompetenzCardsComponent } from './kompetenz-cards/kompetenz-cards.component'
import { KompetenzSideMenuComponent } from './kompetenz-side-menu/kompetenz-side-menu.component'
import { KompetenzKategoryComponent } from './kompetenz-kategory/kompetenz-kategory.component'
import { KompetenzSucheComponent } from './kompetenz-suche/kompetenz-suche.component'
import { KompetenzComponent} from './kompetenz/kompetenz.component'
import { RegisterComponent } from './register/index';
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
    { path: 'kompetenzpflege', component: KompetenzpflegeComponent, canActivate: [AuthGuard],
        children:[
              {
                    path: '',
                    component: KompetenzKategoryComponent
              },
              {
                  path: '',
                  outlet: 'suche',
                  component: KompetenzSucheComponent
              },
              {
                    path: ':id',
                    component: KompetenzKategoryComponent
              },
              {
                    path: '',
                    outlet: 'sidemenu',
                    component: KompetenzSideMenuComponent
              },
              {
                  path: 'type/:id',
                  component: KompetenzKategoryComponent
              }
        ]},
    { path: 'kompetenz/:id', component: KompetenzComponent, canActivate: [AuthGuard]},
    { path: 'profil', component: ProfilComponent, canActivate: [AuthGuard]},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);