import { Component, Input } from '@angular/core';

@Component({
  selector: 'cell',
  template: `
  <div
    [class]="style"
    (click)="onClick()"
  >
  </div>`,
  styleUrls: ['./board.component.scss']
})
export class CellComponent  {
  @Input() rowId: number;
  @Input() id: number;
  style: string;
  value: number = 0;

  ngOnInit() {
    this.style = this.getStyle(this.value);
  }

  onClick() {
    this.value++;
    if (this.value > 3) {
      this.value = 0;
    }
    this.style = this.getStyle(this.value);
  }

  getStyle(value: number): string {
    let style = 'cellContent';
    if (value === 1) {
      style += ' red';
    }
    if (value === 2) {
      style += ' green';
    }
    if (value === 3) {
      style += ' blue';
    }

    return style;
  }
}
