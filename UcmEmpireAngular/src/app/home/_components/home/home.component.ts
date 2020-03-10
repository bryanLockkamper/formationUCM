import { Component, OnInit } from '@angular/core';
import {User} from '../../_models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  player : User;
  constructor() { }

  ngOnInit(): void {
    this.player = null;
  }

}
