import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BoardComponent} from './board/board.component';
import {RowComponent} from "./row/row.component";
import {CellComponent} from "./cell/cell.component";
import { ChoiceComponent } from './choice/choice.component';
import {NbButtonModule, NbCardModule, NbDialogModule} from '@nebular/theme';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    BoardComponent,
    RowComponent,
    CellComponent,
    ChoiceComponent
  ],
  imports: [
    CommonModule,
    NbDialogModule.forChild(),
    NbCardModule,
    NbButtonModule,
    RouterModule,
  ],
})
export class BoardModule { }
