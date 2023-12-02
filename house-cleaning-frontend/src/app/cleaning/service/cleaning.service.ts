import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CleaningResponse} from '../model/cleaning-response';
import {Observable} from 'rxjs';
import {PageRequest} from '../../core/model/page-request';
import {PageResponse} from '../../core/model/page-response';
import {CleaningRequest} from '../model/cleaning-request';

@Injectable({
  providedIn: 'root'
})
export class CleaningService {

  constructor(private http: HttpClient) {}

  getAllCleanings(request: PageRequest): Observable<PageResponse<CleaningResponse[]>> {
    return this.sendRequest('POST', 'http://192.168.0.14:8083/cleaning/get-all',  request);
  }

  saveCleaning(reques: CleaningRequest): Observable<PageResponse<CleaningResponse[]>> {
    return this.sendRequest('POST', 'http://192.168.0.14:8083/cleaning/save', reques);
  }

  private sendRequest<T, V>(httpMethod: string, url: string, body?: V): Observable<T> {
    return this.http.request<T>(httpMethod, url, {
      body: body
    });
  }

}
