import {TestBed} from '@angular/core/testing';

import {SecurityService} from './security.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('SecurityService', () => {
  let service: SecurityService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.inject(SecurityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
