import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'row',
  templateUrl: './row.component.html',
    styleUrls: [ '../board/board.component.scss' ]
})

export class RowComponent implements OnInit {
  @Input() dimension: number;
  @Input() id: number;
  cells = [];
  @Input() row;

  style: string;
  @Output() cell = new EventEmitter<{rowId: number, id: number}>();

  ngOnInit() {
    this.style = 'square pure-u-1-' + this.dimension;
    for (let i = 0; i < this.dimension; i++) {
      this.cells.push({
        rowId: this.id,
        id: i,
        content: this.row.row[i]
      });
    }
  }

  onCellClick(cell) {
    this.cell.emit(cell);
  }
}
