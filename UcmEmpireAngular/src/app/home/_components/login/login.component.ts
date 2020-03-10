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
  j1 : UserInfo;

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
    this.j1 = null;
  }

  log() {
    let json = this.logForm.value;
    this.secService.login(json).subscribe(
      (token) => {
        this.j1 = token;

        localStorage.setItem('token', JSON.stringify(token));
        /*let tokenDecoded = decode(token);
        console.log("Decrypt "+tokenDecoded['mail']);*/
        //let name = tokenDecoded['firstname'];
        this.toastrServ.success('Bonjour '+this.j1.firstname,'Connexion', {[status]:'success'});
        this.router.navigateByUrl('/home');
      },
      (error) => {
        this.toastrServ.danger('Login ou mot de passe incorrect','Error', {[status]:'danger'});

      },
      () => {

      }
    );
  }
}
