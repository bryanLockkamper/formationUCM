import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NbThemeModule, NbLayoutModule, NbCardModule, NbToastrService, NbToastrModule, NbActionsModule} from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { HomeModule } from './home/home.module';
import {BoardModule} from "./board/_components/board.module";
import { GuillaumePipe } from './_pipess/guillaume.pipe';
import { FormsModule } from '@angular/forms';
import { ToolBarComponent } from './navBar/tool-bar/tool-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    GuillaumePipe,
    ToolBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({name: 'dark'}),
    NbLayoutModule,
    NbEvaIconsModule,
    NbCardModule,
    FormsModule,
    HomeModule,
    BoardModule,
    NbToastrModule.forRoot(),
    NbActionsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
