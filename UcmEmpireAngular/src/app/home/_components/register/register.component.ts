import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserRegister } from '../../_models/user-register';
import { SecurityService } from '../../security.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  userform : FormGroup

  usermodel: UserRegister

  constructor(
    private userServ: SecurityService
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

    this.userServ.register(this.usermodel).subscribe();
  }

}
