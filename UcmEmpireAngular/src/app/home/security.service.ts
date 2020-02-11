import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { UserLogin } from './_models/user-login';
import { UserRegister } from './_models/user-register';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(
    private httpClient: HttpClient
  ) { }

  login(model: UserLogin): Observable<string> {
    return this.httpClient.post<string>(environment.apiEndPoint + '/login', model);
  }

  logout() {
    localStorage.clear();
  }

  register(model: UserRegister): Observable<string> {
    return this.httpClient.post<string>(environment.apiEndPoint + '/register', model);

  }
}
