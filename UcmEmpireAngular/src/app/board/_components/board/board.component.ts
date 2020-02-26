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

  timeLeft: number = 120;
  interval;

  constructor(
    private boardService: BoardService,
  ) {
  }

  ngOnInit() {
    this.refresh();
    this.startTimer();
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

  startTimer() {
    this.boardService.startTimer();
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.endTurn();
      }
    },1000)
  }

  endTurn() {
    this.boardService.stopTimer();
    clearInterval(this.interval);
    this.timeLeft = 120;
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
        if (board[i][j].content != null && board[i][j].content.idUser == 0)
          content += '_BLUE';
        else
          content += '_RED';
      }
    }
    return content;
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
