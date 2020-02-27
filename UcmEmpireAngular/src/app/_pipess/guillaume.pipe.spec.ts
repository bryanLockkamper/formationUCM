import { GuillaumePipe } from './guillaume.pipe';

describe('GuillaumePipe', () => {
  it('create an instance', () => {
    const pipe = new GuillaumePipe();
    expect(pipe).toBeTruthy();
  });

  it('create an instance', () => {
    const pipe = new GuillaumePipe();
    const value = pipe.transform('Guillaume', 'mange', 'beaucoup', 'de');
    expect(value).toBe('Guillaume mange beaucoup de sushi!!!');
  });
});
