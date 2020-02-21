import {Component, Input, OnInit} from '@angular/core';
import {BoardService} from "../../_services/board.service";
import {RowModel} from "../../_models/row";

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {
  @Input() dimension: number;
  rows = [];
  board: RowModel[];
  first;


  constructor(
    private boardService: BoardService,
  ) {
  }

  ngOnInit() {
    this.rows = [];
    this.first = null;
    this.boardService.getBoard().subscribe(board => {
      this.board = board;
      this.dimension = board.length;
      for (let i = 0; i < this.dimension; i++) {
        for (let j = 0; j < this.dimension; j++) {
          sessionStorage.setItem('' + i + j, this.getContent(board, i, j));
        }
      }
      for (let i = 0; i < this.dimension; i++) {
        this.rows.push({
          dimension: this.dimension,
          id: i,
          row: board[i],
        });
      }
    });
  }

  onClick(cell) {
    if (this.first == null)
      this.first = this.board[cell.rowId][cell.id].content == null ? null : this.board[cell.rowId][cell.id].special ? null : cell;
    else {
      if (this.board[cell.rowId][cell.id].content == null && this.board[this.first.rowId][this.first.id].content.pa > 0) {
        this.boardService.move([this.first, cell]).subscribe(() => {
          this.rows[cell.rowId].row[cell.id].content = this.rows[this.first.rowId].row[this.first.id].content;
          this.rows[this.first.rowId].row[this.first.id].content = null;
          this.refresh();
        });
        // attack
      } else if (this.board[this.first.rowId][this.first.id].content.damage && !this.board[cell.rowId][cell.id].special) {
        if (this.board[cell.rowId][cell.id].content.idUser != this.board[this.first.rowId][this.first.id].content.idUser && this.board[this.first.rowId][this.first.id].content.pa > 0) {
          this.board[cell.rowId][cell.id].content.hp -= this.board[this.first.rowId][this.first.id].content.damage;
          this.board[this.first.rowId][this.first.id].content.pa = 0;
          if (this.board[cell.rowId][cell.id].content.hp <= 0) {
            this.boardService.deathEntity(cell).subscribe(() => {
              this.rows[cell.rowId].row[cell.id].content = null;
              this.refresh();
            });
          } else this.first = null;
        }
      } else
        this.first = null;
    }
  }

  getContent(board, i, j) {
    let content;

    if (board[i][j].content == null)
      content = null;
    else {
      if (board[i][j].special)
        content = board[i][j].content.resourceName;
      else {
        if (board[i][j].content.damage) {
          content = 'SOLDAT';
        } else {
          content = 'FARMER'
        }
        let currentSquare = board[i][j];
        //Pour le moment, le brouillard fonctionne selon la logique que le player 0 est le seul à voir de son côté. 
        //Cette condition permet de faire apparaître un brouillard seulement selon le joueur 0.
        if (currentSquare.content.idUser == 0){
          board[i][j].overlayed = false;
            //Active la vision périphérique (N'a pas d'influence sur l'API. Ceci est cosmétique avant que l'api ne soit mise à jour)
            for (let x = -1; x <= 1; x++){
              for (let y = -1; y <= 1; y++){
                if (
                  (i+x >=0 && j+y >= 0)
                  && (i+x < board.length && j+y < board.length)
                ){
                  board[i+x][j+y].overlayed = false;
                }
              }
            }
          }
        if (currentSquare.content != null && currentSquare.content.idUser == 0) {
          content += '_BLUE';
        } else
          content += '_RED';
      }
    }
    return content;
  }

  getOverlayed(board, i, j){
      return board[i][j].overlayed;
  }


  refresh() {
    for (let i = 0; i < this.dimension; i++) {
      for (let j = 0; j < this.dimension; j++) {
        sessionStorage.setItem('' + i + j, this.getContent(this.board, i, j));
      }
    }
    this.rows = [];
    for (let i = 0; i < this.dimension; i++) {
      this.rows.push({
        dimension: this.dimension,
        id: i,
        row: this.board[i],
      });
    }
    this.first = null;
  }
}
