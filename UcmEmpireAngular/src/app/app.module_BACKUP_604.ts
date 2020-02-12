import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
<<<<<<< HEAD
import { NbThemeModule, NbLayoutModule, NbCardModule, NbIconModule, NbInputModule, NbButtonModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { HomeModule } from './home/home.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
=======
import { NbThemeModule, NbLayoutModule, NbCardModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { HomeModule } from './home/home.module';
import {BoardModule} from "./board/board.module";

@NgModule({
  declarations: [
    AppComponent
>>>>>>> 6f1695420e6bd469ba97aade850388fbcd1e8756
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'dark' }),
    NbLayoutModule,
    NbEvaIconsModule,
<<<<<<< HEAD
    NbCardModule,
    NbIconModule,
    NbInputModule,
    NbButtonModule,
    FormsModule,
    HttpClientModule,
    
    HomeModule,
=======
    HomeModule,
    BoardModule
>>>>>>> 6f1695420e6bd469ba97aade850388fbcd1e8756
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
