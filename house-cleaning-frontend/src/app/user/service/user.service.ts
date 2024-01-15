import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserResponse} from "../model/user-response";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<UserResponse[]> {
    return this.sendRequest('GET', 'http://192.168.0.14:8083/user/get-all');
  }

  private sendRequest<T, V>(httpMethod: string, url: string, body?: V): Observable<T> {
    return this.http.request<T>(httpMethod, url, {
      body: body
    });

  }
}
