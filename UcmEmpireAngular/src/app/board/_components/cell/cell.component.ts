import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'cell',
  templateUrl: './cell.component.html',
  styleUrls: ['../board/board.component.scss']
})
export class CellComponent implements OnInit {
  @Input() rowId: number;
  @Input() id: number;
  style: string;
  value: number = 0;
  sheet: string;

  constructor() {
  }

  ngOnInit() {
    this.sheet = this.getSheet();
    // this.style = this.getStyle(this.value);
    this.style = 'cellContent';
  }

  onClick() {

  }

  getSheet() {
    let content = sessionStorage.getItem('' + this.rowId + this.id);
    switch (content) {
      case 'STONE':
        return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
      case 'WOOD' :
        return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
      case 'SOLDAT':
        return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
      case null:
        return 'assets/_img/grass.png';
      default:
        return 'assets/_img/grass.png';
    }

  }
}
