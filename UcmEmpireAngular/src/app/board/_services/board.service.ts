import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserLogin} from "../../home/_models/user-login";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {RowModel} from "../_models/row";

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

  startTimer() {
    console.log("START");
    
    this.httpClient.get(environment.apiEndPoint + '/timer/start').subscribe();
  }

  stopTimer() {
    console.log("STOP");

    this.httpClient.get(environment.apiEndPoint + '/timer/stop').subscribe();
  }

  deathEntity(model): Observable<void> {
    return this.httpClient.post<void>(environment.apiEndPoint + 'deathEntity', model);
  }

  getResource(model){
    return this.httpClient.get(environment.apiEndPoint+'/player/res/'+ model.user_id)
  }
}
