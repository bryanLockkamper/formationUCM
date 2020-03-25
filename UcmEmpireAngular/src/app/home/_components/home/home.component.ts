import { Component, OnInit } from '@angular/core';
import {User} from '../../_models/user';
import {UserInfo} from '../../_models/user-info';
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  player : UserInfo;
  constructor() { }

  ngOnInit(): void {
    this.player = localStorage.getItem('token') ? decode(localStorage.getItem('token'))['userInfo'] : null;
  }

}
