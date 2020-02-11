import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityService } from '../../security.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  logForm: FormGroup;

  constructor(
    private secService: SecurityService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.logForm = new FormGroup({
      pseudo: new FormControl(null, Validators.required),
      pwd: new FormControl(null, Validators.required)
    });
  }

  log() {
    const json = this.logForm.value;
    this.secService.login(json).subscribe(
      (token) => {
        localStorage.setItem('token', token);
        this.router.navigateByUrl('/home');
      },
      () => {
      },
      () => {

      }
    );
  }
}
