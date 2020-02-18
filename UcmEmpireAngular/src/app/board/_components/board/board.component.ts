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

  timeLeft: number = 120;
  interval;

  constructor(
    private boardService: BoardService,
  ) {
  }

  ngOnInit() {
    this.refresh();
    this.startTimer();
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
  }

  move(cell) {
    if (this.first == null)
      this.first = cell;
    else {
      this.boardService.move([this.first, cell]).subscribe(() => {
        sessionStorage.clear();
        this.refresh();
      });
    }
  }

  refresh() {
    this.rows = [];
    this.first = null;
    this.boardService.getBoard().subscribe(board => {
      this.dimension = board.length;
      for (let i = 0; i < this.dimension; i++) {
        for (let j = 0; j < this.dimension; j++) {
          sessionStorage.setItem('' + i + j, board[i][j].content != null ? board[i][j].special ? board[i][j].content.resourceName : 'SOLDAT' : null);
        }
      }
      for (let i = 0; i < this.dimension; i++) {
        this.rows.push({
          dimension: this.dimension,
          id: i
        });
      }
    });
  }
}
