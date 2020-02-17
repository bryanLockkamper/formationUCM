import {Component, Input, OnInit} from '@angular/core';
import {BoardService} from "../../_services/board.service";
import {RowModel} from "../../_models/row";
import {BehaviorSubject, Observable} from "rxjs";

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
    this.refresh();
  }

  onClick(cell) {
    if (this.first == null)
      this.first = this.board[cell.rowId][cell.id].content == null ? null : this.board[cell.rowId][cell.id].special ? null : cell;
    else {
      if (this.board[cell.rowId][cell.id].content == null) {
        this.boardService.move([this.first, cell]).subscribe(() => {
          sessionStorage.clear();
          this.refresh();
        });
        // attack
      } else if (this.board[this.first.rowId][this.first.id].content.damage && !this.board[cell.rowId][cell.id].special) {
        if (this.board[cell.rowId][cell.id].content.idUser != this.board[this.first.rowId][this.first.id].content.idUser) {
          this.board[cell.rowId][cell.id].content.hp -= this.board[this.first.rowId][this.first.id].content.damage;
          // TODO retirer les pa
          if (this.board[cell.rowId][cell.id].content.hp <= 0) {
            this.boardService.deathEntity(cell).subscribe(() => {
              sessionStorage.clear();
              this.refresh();
            });
          } else this.first = null;
        }
      } else
        this.first = null;
    }
  }

  refresh() {
    this.rows = [];
    this.first = null;
    this.boardService.getBoard().subscribe(board => {
      this.board = board;
      this.dimension = board.length;
      for (let i = 0; i < this.dimension; i++) {
        for (let j = 0; j < this.dimension; j++) {
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
              if (board[i][j].content != null && board[i][j].content.idUser == 0)
                content += '_BLUE';
              else
                content += '_RED';
            }
          }
          sessionStorage.setItem('' + i + j, content);
        }
      }
      for (let i = 0; i < this.dimension; i++) {
        this.rows.push({
          dimension: this.dimension,
          id: i,
          row: board[i]
        });
      }
    });
  }
}
