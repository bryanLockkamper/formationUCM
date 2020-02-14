import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BoardComponent} from './_components/board/board.component';
import {RowComponent} from "./_components/row/row.component";
import {CellComponent} from "./_components/cell/cell.component";


@NgModule({
  declarations: [
    BoardComponent,
    RowComponent,
    CellComponent,
  ],
  imports: [
    CommonModule,
  ]
})
export class BoardModule { }
