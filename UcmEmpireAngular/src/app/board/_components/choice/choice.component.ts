import { Component, OnInit } from '@angular/core';
import {NbDialogRef} from "@nebular/theme";

@Component({
  selector: 'app-choice',
  templateUrl: './choice.component.html',
  styleUrls: ['./choice.component.scss']
})
export class ChoiceComponent implements OnInit {

  entity;

  constructor(
    private dialog : NbDialogRef<ChoiceComponent>
  ) { }

  ngOnInit(): void {
  }

  attack() {
    this.dialog.close('attack');
  }

  move() {
    this.dialog.close('move');
  }

  moveFarmer() {
    this.dialog.close('moveFarmer');
  }

  suicide() {
    this.dialog.close('suicide');
  }
}
