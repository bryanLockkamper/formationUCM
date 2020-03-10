import { Component, OnInit } from '@angular/core';
import {User} from '../../_models/user';
import {UserInfo} from '../../_models/user-info';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  player : UserInfo;
  constructor() { }

  ngOnInit(): void {
    this.player = ((typeof localStorage.getItem('token') != undefined) && (localStorage.getItem('token') != null)) ? JSON.parse(localStorage.getItem('token')) : null ;
  }

}
