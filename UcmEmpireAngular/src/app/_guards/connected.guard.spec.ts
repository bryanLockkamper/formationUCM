import { TestBed } from '@angular/core/testing';

import { ConnectedGuard } from './connected.guard';
import {RouterTestingModule} from "@angular/router/testing";
import {ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";


describe('ConnectedGuard', () => {
  let guard: ConnectedGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule]
    });
    guard = TestBed.inject(ConnectedGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });

  it('#canAvtivate with no Auth', () => {
    expect(guard.canActivate(new ActivatedRouteSnapshot(), <RouterStateSnapshot>{url: '/board'})).toBeFalse();
  });

  it('#canAvtivate with Auth', () => {
    localStorage.setItem('token', 'un token ');
    expect(guard.canActivate(new ActivatedRouteSnapshot(), <RouterStateSnapshot>{url: '/board'})).toBeTrue();
    localStorage.clear();
  });
});
