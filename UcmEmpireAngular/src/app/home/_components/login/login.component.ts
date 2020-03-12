import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityService } from '../../security.service';
import * as decode from 'jwt-decode';
import {NbToastrService} from '@nebular/theme';
import {UserInfo} from '../../_models/user-info';

@Component({
  selector: 'app-home',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  logForm: FormGroup;

  constructor(
    private secService: SecurityService,
    private router: Router,
    private toastrServ : NbToastrService,
  ) { }

  ngOnInit(): void {
    this.logForm = new FormGroup({
      pseudo: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    });
  }

  log() {
    let json = this.logForm.value;
    this.secService.login(json).subscribe(
      (model) => {
        localStorage.setItem('token', JSON.stringify(model['token']));
        /*let tokenDecoded = decode(model['token']);
        console.log("test "+tokenDecoded);*/
        let name = model['username'];
        this.toastrServ.success('Bonjour ' + name,'Connexion', {[status]:'success'});
        this.router.navigateByUrl('/home');
      },
      (error) => {
        this.toastrServ.danger('Login ou mot de passe incorrect','Error', {[status]:'danger'});

      },
      () => {
        console.log("huuh");

      }
    );
  }
}
