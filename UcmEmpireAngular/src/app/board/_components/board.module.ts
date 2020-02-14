import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BoardComponent} from './board/board.component';
import {RowComponent} from "./row/row.component";
import {CellComponent} from "./cell/cell.component";


@NgModule({
  declarations: [
    BoardComponent,
    RowComponent,
    CellComponent
  ],
  imports: [
    CommonModule,
  ],
})
export class BoardModule { }
