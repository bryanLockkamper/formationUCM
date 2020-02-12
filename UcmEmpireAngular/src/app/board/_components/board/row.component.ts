import { Component, Input } from '@angular/core';

@Component({
  selector: 'row',
  template: `
  <ng-template
    ngFor let-cell [ngForOf]="cells"
  >
    <cell
      class="{{style}}"
      (click)="onCellClick($event, cell)"
    >
    </cell>
  </ng-template>`,
    styleUrls: [ './board.component.scss', '../css/pure-min.css' ]
})
export class RowComponent  {
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
    var target = event.target || event.srcElement || event.currentTarget;
    var idAttr = target.attributes;
    console.log(cell);
  }
}
