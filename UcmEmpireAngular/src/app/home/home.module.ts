<<<<<<< HEAD
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './_components/home/home.component';
import { NbCardModule, NbDatepickerModule, NbInputModule, NbSelectModule
  , NbCheckboxModule, NbButtonModule, NbIconModule } from '@nebular/theme';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegisterComponent } from './_components/register/register.component';


@NgModule({
  declarations: [HomeComponent, RegisterComponent],
=======
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './_components/home/home.component';
import {NbButtonModule, NbCardModule, NbIconModule, NbInputModule} from '@nebular/theme';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NbEvaIconsModule} from '@nebular/eva-icons';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [HomeComponent],
>>>>>>> 6f1695420e6bd469ba97aade850388fbcd1e8756
  imports: [
    CommonModule,
    NbCardModule,
    FormsModule,
    NbInputModule,
    ReactiveFormsModule,
    NbButtonModule,
    NbIconModule,
    NbEvaIconsModule,
    HttpClientModule,
  ]
})
export class HomeModule { }
