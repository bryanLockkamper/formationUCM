import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'row',
  templateUrl: './row.component.html',
    styleUrls: [ '../board/board.component.scss']
})

export class RowComponent implements OnInit {
  @Input() dimension: number;
  @Input() id: number;
  cells = [];
  style: string;

  ngOnInit() {
    this.style = 'square pure-u-1-' + this.dimension;
    for (let i = 0; i < this.dimension; i++) {
      this.cells.push({
        rowId: this.id,
        id: i
      });
    }
  }

  onCellClick(event, cell) {
    const target = event.target || event.currentTarget;
    const idAttr = target.attributes;
    console.log(cell);
  }
}
