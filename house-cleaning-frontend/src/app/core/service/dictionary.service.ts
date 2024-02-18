import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DictionaryEntryResponse} from '../model/dictionary-entry-response';
import {AppConfig} from '../../config';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  constructor(private http: HttpClient) {
  }

  getAllDictionaries(): Observable<DictionaryEntryResponse[]> {
    return this.sendRequest('GET', `${AppConfig.serverAddress}/dictionary/get-all`);
  }

  private sendRequest<T, V>(httpMethod: string, url: string, body?: V): Observable<T> {
    return this.http.request<T>(httpMethod, url, {
      body: body
    });
  }

}
