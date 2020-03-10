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
  }

  getSheet() {
    let content;
    if (this.content.content == null)
      content = null;
    else {
      if (this.content.special)
        content = this.content.content.typeRessource;
      else {
        content = this.content.content.typeEntity.toUpperCase();
        let currentSquare = this.content;
        /*if (this.content.content.idPlayer != 0) {
          //Pour le moment, le brouillard fonctionne selon la logique que le player 0 est le seul à voir de son côté.
          //Cette condition permet de faire apparaître un brouillard seulement selon le joueur 0.
          if (currentSquare.content.idPlayer == 1) {
            this.content.overlayed = false;
            //Active la vision périphérique (N'a pas d'influence sur l'API. Ceci est cosmétique avant que l'api ne soit mise à jour)
            for (let x = -1; x <= 1; x++) {
              for (let y = -1; y <= 1; y++) {
                if (
                  (this.rowId + x >= 0 && this.id + y >= 0)
                  && (this.rowId + x < board.length && j + y < board.length)
                ) {
                  board[i + x][j + y].overlayed = false;
                }
              }
            }
          }
        }*/
        if (currentSquare.content != null && currentSquare.content.idPlayer != 0) {
          content += '_BLUE';
        } else
          content += '_RED';
      }
    }
    let overlayed = this.content.overlayed;
    //Oui je sais c'est dégueulasse mais c'est pour afficher les unités du player 0 seulement. C'est Bryan qui a demandé.
    if(!overlayed){
      if (content) {
        return 'assets/_img/' + content.toLocaleLowerCase() + '.jpg';
      } else {
        return 'assets/_img/grass.png';
      }
    } else {
      return 'assets/_img/fog.jpg';
    }
  }
}
