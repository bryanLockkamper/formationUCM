import { Component } from '@angular/core';
import {SecurityService} from './home/security.service';
import {NbToastrService} from '@nebular/theme';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'UcmEmpireAngular';

}
