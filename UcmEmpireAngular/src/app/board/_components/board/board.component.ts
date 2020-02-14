import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {
  @Input() dimension: number;
  rows = [];

  constructor() {
  }

  ngOnInit() {
    this.dimension = 6;
    for (let i = 0; i < this.dimension; i++) {
      this.rows.push({
        dimension: this.dimension,
        id: i
      });
    }
  }

}
