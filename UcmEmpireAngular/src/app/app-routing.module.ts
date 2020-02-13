import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/_components/home/home.component';
import { RegisterComponent } from './home/_components/register/register.component';
import {BoardComponent} from "./board/_components/board/board.component";
import {ConnectedGuard} from "./_guards/connected.guard";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'board', component: BoardComponent, canActivate: [ConnectedGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
