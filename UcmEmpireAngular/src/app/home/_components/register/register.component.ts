import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserRegister } from '../../_models/user-register';
import { SecurityService } from '../../security.service';
import { Router } from '@angular/router';
import {NbToastrService} from '@nebular/theme';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  userform : FormGroup

  usermodel: UserRegister

  constructor(
    private userServ: SecurityService,
    private routServ: Router,
    private toastrServ : NbToastrService,

  ) { }

  ngOnInit(): void {
    this.userform = new FormGroup( {
       "pseudo": new FormControl(),
       "password": new FormControl(),
       "firstname": new FormControl(),
       "lastname": new FormControl(),
       "email": new FormControl()
    });
  }

  validate()
  {
    this.usermodel = this.userform.value;

    this.userServ.register(this.usermodel).subscribe(
      (model) => {
        this.toastrServ.success('Bienvenu dans notre communauté ' + this.usermodel.pseudo,'Enregistrement', {[status]:'success'});
      },
      () => {
        this.toastrServ.success('Erreur dans l"enregistrement ','Enregistrement', {[status]:'danger'});
      },
      () => {},
    );
    this.routServ.navigateByUrl('/board')
  }

}
