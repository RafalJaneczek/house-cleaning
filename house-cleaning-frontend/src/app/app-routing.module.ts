import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CleaningComponent} from './cleaning/component/cleaning.component';
import {DashboardComponent} from './dashboard/component/dashboard.component';
import {CleaningProductComponent} from "./cleaning-product/component/cleaning-product.component";

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'dashboard'
  },
  {
    path: 'cleaning',
    component: CleaningComponent
  },
  {
    path: 'cleaning-product',
    component: CleaningProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
