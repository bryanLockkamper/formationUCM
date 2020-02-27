import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'guillaume'
})
export class GuillaumePipe implements PipeTransform {

  transform(value: string, ...args: string[]): unknown {
    return value += ' ' + args.join(' ') + ' sushi!!!';
  }

}
