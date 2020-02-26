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
  sheet: string;
  @Input() content;

  constructor() {
  }

  ngOnInit() {
    this.sheet = this.getSheet();
    this.style = 'cellContent';
  }

  onClick() {
    console.log(this.content);
  }

  getSheet() {
    let content = sessionStorage.getItem('' + this.rowId + '-' + this.id);
    let overlayed = this.content.overlayed;
    //Oui je sais c'est dégueulasse mais c'est pour afficher les unités du player 0 seulement. C'est Bryan qui a demandé.
    if(!overlayed){
      switch (content) {
        case 'STONE':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'WOOD' :
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'SOLDAT_BLUE':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'SOLDAT_RED':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'FARMER_BLUE':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'FARMER_RED':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case 'FOOD':
          return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
        case null:
          return 'assets/_img/grass.png';
        default:
          return 'assets/_img/grass.png';
      }
    } else {
      return 'assets/_img/fog.jpg';
    }
  }
}
