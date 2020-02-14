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
}
