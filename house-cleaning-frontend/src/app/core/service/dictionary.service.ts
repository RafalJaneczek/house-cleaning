import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DictionaryEntryResponse} from '../model/dictionary-entry-response';
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  constructor(private http: HttpClient) {
  }

  getAllDictionaries(): Observable<DictionaryEntryResponse[]> {
    return this.sendRequest('GET', `${environment.apiBaseUrl}/dictionary/get-all`);
  }

  private sendRequest<T, V>(httpMethod: string, url: string, body?: V): Observable<T> {
    return this.http.request<T>(httpMethod, url, {
      body: body
    });
  }

}
