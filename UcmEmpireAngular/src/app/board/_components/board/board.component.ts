import {Component, Input, OnInit} from '@angular/core';
import {BoardService} from "../../_services/board.service";
import {RowModel} from "../../_models/row";
import {NbDialogService} from "@nebular/theme";
import {ChoiceComponent} from "../choice/choice.component";
import { UserHasLost } from 'src/app/home/_models/user-haslost';

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
  private action;
  private move: boolean;
  private attack: boolean;

  playerList : UserHasLost[]

  constructor(
    private boardService: BoardService,
    private dialog: NbDialogService,
  ) {
  }

  ngOnInit() {
    this.rows = [];
    this.playerList = [];
    this.first = null;
    this.boardService.getBoard().subscribe(board => {
      this.board = board;
      this.dimension = board.length;
      for (let i = 0; i < this.dimension; i++) {
        this.rows.push({
          dimension: this.dimension,
          id: i,
          row: board[i],
        });
      }
    });
    this.startTimer();
    this.haslost(this.playerList);
  }

  startTimer() {
    this.boardService.startTimer();
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.endTurn();
      }
    }, 1000);
    console.log(this.playerList.length);

    this.playerList.forEach(element => {
      if(element.player_hasLost)
      {
        console.log('le joueur ' + element.player_id + ' a perdu');

      }
      else
      {
        console.log('Tu n\'as pas encore perdu' );

      }
    });
  }

  endTurn() {
    this.boardService.stopTimer();
    clearInterval(this.interval);
    this.timeLeft = 120;
    this.refresh();
    this.playerList = [];
    this.playerList.push(this.haslost(this.playerList));
  }

  haslost(playerList): any {
    return this.boardService.ishaslost(playerList).subscribe();
  }

  onClick(cell) {
    if (this.first == null) {
        this.first = cell;
        if (this.first != null && (this.board[cell.rowId][cell.id].special || this.board[cell.rowId][cell.id].content?.idPlayer == 1)) {
          this.action = this.dialog.open(ChoiceComponent, {context: {entity: this.board[cell.rowId][cell.id]}});
          this.action.onClose.subscribe(value => {
            switch (value) {
              case 'suicide':
                this.boardService.deathEntity(cell).subscribe(() => {
                  this.refresh();
                });
                break;
              case 'move':
                this.move = true;
                break;
              case 'attack' :
                this.attack = true;
                break;
              default:
                this.first = null;
            }
          });
        } else {
          this.first = null;
        }
    } else {
      if (this.move && this.board[this.first.rowId][this.first.id].content.pa > 0) {
        this.boardService.move([this.first, cell]).subscribe(() => {
          this.refresh();
          this.move = false;
        });
        // attack
      } else if (this.attack && this.board[this.first.rowId][this.first.id].content.damage && !this.board[cell.rowId][cell.id].special) {
        if (this.board[cell.rowId][cell.id].content.idPlayer != this.board[this.first.rowId][this.first.id].content.idPlayer && this.board[this.first.rowId][this.first.id].content.pa > 0) {
          this.boardService.attack([this.first, cell]).subscribe(() => {
            this.refresh();
          })
        } else
          this.first = null;
        this.attack = false;
      } else
        this.first = null;
    }
  }

  // todo transferer vers cell compnents?
  getContent(board, i, j) {
    let content;

    if (board[i][j].content == null)
      content = null;
    else {
      if (board[i][j].special)
        content = board[i][j].content.typeRessource;
      else {
        if (board[i][j].content.damage) {
          content = 'SOLDAT';
        } else {
          content = 'FARMER';
        }
        let currentSquare = board[i][j];
        if (board[i][j].content.idPlayer == 1) {
          //Pour le moment, le brouillard fonctionne selon la logique que le player 0 est le seul à voir de son côté.
          //Cette condition permet de faire apparaître un brouillard seulement selon le joueur 0.
          if (currentSquare.content.idPlayer == 1) {
            board[i][j].overlayed = false;
            //Active la vision périphérique (N'a pas d'influence sur l'API. Ceci est cosmétique avant que l'api ne soit mise à jour)
            for (let x = -1; x <= 1; x++) {
              for (let y = -1; y <= 1; y++) {
                if (
                  (i + x >= 0 && j + y >= 0)
                  && (i + x < board.length && j + y < board.length)
                ) {
                  board[i + x][j + y].overlayed = false;
                }
              }
            }
          }
        }
        if (currentSquare.content != null && currentSquare.content.idPlayer == 1) {
          content += '_BLUE';
        } else
          content += '_RED';
      }
    }
    return content;
  }

  getOverlayed(board, i, j) {
    return board[i][j].overlayed;
  }

  refresh() {
    this.boardService.getBoard().subscribe(value => {
      this.board = value;
      this.rows = [];
      for (let i = 0; i < this.dimension; i++) {
        this.rows.push({
          dimension: this.dimension,
          id: i,
          row: this.board[i],
        });
      }
      this.first = null;
    })
  }
}
