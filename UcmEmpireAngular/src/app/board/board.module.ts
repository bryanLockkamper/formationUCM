import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BoardComponent } from './_components/board/board.component';
import {HelloComponent} from "./_components/board/hello.component";
import {RowComponent} from "./_components/board/row.component";
import {CellComponent} from "./_components/board/cell.component";



@NgModule({
  declarations: [
    HelloComponent,
    BoardComponent,
    RowComponent,
    CellComponent
  ],
  imports: [
    CommonModule,

  ]
})
export class BoardModule { }
