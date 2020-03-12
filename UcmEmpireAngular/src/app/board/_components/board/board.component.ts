import {Component, Input, OnInit} from '@angular/core';
import {BoardService} from "../../_services/board.service";
import {RowModel} from "../../_models/row";
import {NbDialogService} from "@nebular/theme";
import {ChoiceComponent} from "../choice/choice.component";
import {UserHasLost} from 'src/app/home/_models/user-haslost';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {
  dimension: number;
  rows = [];
  board: RowModel[];
  first;
  timeLeft: number = 120;
  interval;
  private action;
  private move: boolean;
  private attack: boolean;
  playerList: UserHasLost[];
  private createBarrack: boolean;
  private idPlayerPlay: number;
  resources = [];

  constructor(
    private boardService: BoardService,
    private dialog: NbDialogService,
  ) {
  }

  ngOnInit() {
    this.rows = [];
    this.playerList = [];
    this.first = null;
    this.boardService.newBoard().subscribe(board => {
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
    this.boardService.ishaslost().subscribe(value => {
      this.playerList = value;
      this.idPlayerPlay = this.playerList[1].player_id;
      this.boardService.getResource(this.idPlayerPlay).subscribe(value1 => {
        this.resources = value1['resources'];
        this.startTimer();
      });
    });
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

    this.playerList.forEach(element => {
      if (element.player_hasLost) {
        console.log('le joueur ' + element.player_id + ' a perdu');

      } else {
        console.log('Tu n\'as pas encore perdu');

      }
    });
    this.refresh();
  }

  endTurn() {
    this.boardService.stopTimer();
    clearInterval(this.interval);
    this.timeLeft = 120;
    this.boardService.ishaslost().subscribe(value => {
      this.playerList = value;
      if (this.idPlayerPlay == this.playerList[0].player_id) {
        this.idPlayerPlay = this.playerList[1].player_id;
      } else {
        this.idPlayerPlay = this.playerList[0].player_id;
      }
      this.boardService.getResource(this.idPlayerPlay).subscribe(value1 => {
        this.resources = value1['resources'];
        this.startTimer();
      });
    });
  }

  onClick(cell) {
    if (this.first == null) {
      this.first = cell;
      if (this.first != null && ((this.board[cell.rowId][cell.id].special && this.board[cell.rowId][cell.id].entityDTOList.length > 0) || this.board[cell.rowId][cell.id].content?.idPlayer == this.idPlayerPlay)) {
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
            case 'moveFarmer':
              this.move = true;
              break;
            case 'moveSoldier':
              this.move = true;
              break;
            case 'attack' :
              this.attack = true;
              break;
            case 'createFarmer':
              this.boardService.createFarmer(cell).subscribe();
              this.first = null;
              break;
            case 'createSoldier':
              this.boardService.createSoldier(cell).subscribe();
              this.first = null;
              break;
            case 'createBarrack':
              this.createBarrack = true;
              break;
            default:
              this.first = null;
          }
        });
      } else {
        this.first = null;
      }
    } else {
      if (this.move) {
        this.boardService.move([this.first, cell]).subscribe(() => {
          this.refresh();
          this.move = false;
        });
      } else if (this.attack && !this.board[cell.rowId][cell.id].special) {
        if (this.board[cell.rowId][cell.id].content?.idPlayer != this.board[this.first.rowId][this.first.id].content.idPlayer && this.board[this.first.rowId][this.first.id].content.pa > 0) {
          this.boardService.attack([this.first, cell]).subscribe(() => {
            this.refresh();
          })
        } else
          this.first = null;
        this.attack = false;
        // Condition pour qu'il ne puisse créer que 1 case autour de lui
      } else if (this.createBarrack
        && cell.rowId <= this.first.rowId + 1
        && cell.rowId >= this.first.rowId - 1
        && cell.id <= this.first.id + 1
        && cell.id >= this.first.id - 1
        && !(cell.rowId == this.first.rowId
          && cell.id == this.first.id)
      ) {
        this.boardService.createBarrack([this.first, cell]).subscribe(() => {
          this.refresh();
        })
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
        if (currentSquare.content != null && currentSquare.content.idPlayer != 0) {
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

  deleteBoard() {
    this.board = null;
  }
}
