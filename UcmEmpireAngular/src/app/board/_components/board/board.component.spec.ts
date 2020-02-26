import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BoardComponent} from './board.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {BoardService} from "../../_services/board.service";
import SpyObj = jasmine.SpyObj;
import {BehaviorSubject, Observable} from "rxjs";
import {RowModel} from "../../_models/row";

describe('BoardComponent', () => {
  let component: BoardComponent;
  let fixture: ComponentFixture<BoardComponent>;
  let service: BoardService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BoardComponent],
      imports: [HttpClientTestingModule],
      providers: [BoardService]
    })
      .compileComponents();
    service = TestBed.inject(BoardService);
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('#getBoard should return stubbed value from a spy', () => {
    const stubValue = new BehaviorSubject([{
      "biome": "PLAINS",
      "content": null,
      "special": false,
      "buildable": true,
      "walkable": true
    }]);
    let test = spyOn(service, "getBoard").and.returnValue(stubValue);

    expect(service.getBoard())
      .toBe(stubValue, 'service returned stub value');
    expect(test.calls.count())
      .toBe(1, 'spy method was called once');
    expect(test.calls.mostRecent().returnValue)
      .toBe(stubValue);
  });

  it('#getContent avec board hardcodé', () => {
    const board = [[{"biome": "PLAINS", "content": null, "special": false, "buildable": true, "walkable": true},
      {"biome": "PLAINS", "content": null, "special": false, "buildable": true, "walkable": true},
      {
        "biome": "PLAINS",
        "farmers": null,
        "resourceQuantity": 0,
        "content": {"hp": 50, "resourceName": "FOOD", "nameOfRessource": "food"},
        "special": true,
        "buildable": false,
        "walkable": true
      },
      {"biome": "PLAINS", "content": null, "special": false, "buildable": true, "walkable": true}]];

    expect(component.getContent(board, 0, 2))
      .toBe('FOOD', 'service returned stub value');
  });

  it('#getContent avec mock du service', () => {
    // @ts-ignore
    const stub = new BehaviorSubject<RowModel[]>([[
      {
        "biome": "PLAINS",
        "content": null,
        "special": false,
        "buildable": true,
        "walkable": true
      },
      {"biome": "PLAINS", "content": null, "special": false, "buildable": true, "walkable": true},
      {
        "biome": "PLAINS",
        "farmers": null,
        "resourceQuantity": 0,
        "content": {"hp": 50, "resourceName": "FOOD", "nameOfRessource": "food"},
        "special": true,
        "buildable": false,
        "walkable": true
      },
      {"biome": "PLAINS", "content": null, "special": false, "buildable": true, "walkable": true}]]);





    spyOn(service, 'getBoard').and.returnValue(stub.asObservable());


    service.getBoard().subscribe(value =>
      expect(component.getContent(value, 0, 2))
        .toBe('FOOD', 'service returned stub value'));

  });
});
