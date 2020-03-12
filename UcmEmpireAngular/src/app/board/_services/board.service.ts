import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserLogin} from "../../home/_models/user-login";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {RowModel} from "../_models/row";
import {UserHasLost} from 'src/app/home/_models/user-haslost';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getBoard(): Observable<RowModel[]> {
    return this.httpClient.get<RowModel[]>(environment.apiEndPoint);
  }

  move(model): Observable<void> {
    return this.httpClient.post<void>(environment.apiEndPoint + 'move', model);
  }

  attack(model): Observable<void> {
    return this.httpClient.post<void>(environment.apiEndPoint + 'attack', model);
  }

  startTimer() {
    this.httpClient.get(environment.apiEndPoint + 'timer/start').subscribe();
  }

  stopTimer() {
    this.httpClient.get(environment.apiEndPoint + 'timer/stop').subscribe();
  }

  deathEntity(model): Observable<void> {
    return this.httpClient.post<void>(environment.apiEndPoint + 'deathEntity', model);
  }

  getResource(model){
    return this.httpClient.get(environment.apiEndPoint+'player/res/'+ model)
  }

  newBoard(model) : Observable<RowModel[]>
  {
    return this.httpClient.post<RowModel[]>(environment.apiEndPoint+'newBoard',model);
  }

  ishaslost(): Observable<UserHasLost[]>{
    return this.httpClient.get<UserHasLost[]>(environment.apiEndPoint+'player/haslost');
  }

  createFarmer(model) {
    return this.httpClient.post(environment.apiEndPoint + 'createFarmer', model);
  }

  createBarrack(model) {
    return this.httpClient.post(environment.apiEndPoint + 'createBarrack', model);
  }

  createSoldier(model) {
    return this.httpClient.post(environment.apiEndPoint + 'createSoldier', model);
  }
}
