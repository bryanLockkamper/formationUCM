import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './_components/login/login.component';
import {NbButtonModule, NbCardModule, NbIconModule, NbInputModule} from '@nebular/theme';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NbEvaIconsModule} from '@nebular/eva-icons';
import {HttpClientModule} from '@angular/common/http';
import { RegisterComponent } from './_components/register/register.component';
import { HomeComponent } from './_components/home/home.component';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [LoginComponent, RegisterComponent, HomeComponent],
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
    RouterModule,
  ]
})
export class HomeModule { }
