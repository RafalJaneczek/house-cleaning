import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CleaningComponent} from './cleaning/component/cleaning.component';
import {DashboardComponent} from './dashboard/component/dashboard.component';
import {CleaningService} from './cleaning/service/cleaning.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DictionaryTranslatorPipe} from './core/pipe/dictionary-translator';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { CleaningProductComponent } from './cleaning-product/component/cleaning-product.component';
import {MatTabsModule} from '@angular/material/tabs';


@NgModule({
  declarations: [
    AppComponent,
    CleaningComponent,
    DashboardComponent,
    DictionaryTranslatorPipe,
    CleaningProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatDividerModule,
    MatIconModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatTabsModule
  ],
  providers: [
    CleaningService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
