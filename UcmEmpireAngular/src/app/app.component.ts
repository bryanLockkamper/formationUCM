import { Component } from '@angular/core';
import {SecurityService} from './home/security.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'UcmEmpireAngular';
  private secService: SecurityService;
  token = localStorage.getItem('token');


  logout(){
    this.secService.logout();
  }
}
