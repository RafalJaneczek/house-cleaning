import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PageResponse} from '../../core/model/page-response';
import {CleaningProductResponse} from '../model/cleaning-product-response';
import {CleaningProductRequest} from '../model/cleaning-product-request';
import {CLeaningProductPageRequest} from '../model/cLeaning-product-page-request';

@Injectable({
  providedIn: 'root'
})
export class CleaningProductService {

  constructor(private http: HttpClient) {
  }

  getAllProducts(request: CLeaningProductPageRequest): Observable<PageResponse<CleaningProductResponse[]>> {
    return this.sendRequest('POST', 'http://192.168.0.14:8083/cleaning-product/get-by-product-name', request);
  }

  saveProduct(request: CleaningProductRequest): Observable<PageResponse<any>> {
    return this.sendRequest('POST', 'http://192.168.0.14:8083/cleaning-product/save', request);
  }

  private sendRequest<T, V>(httpMethod: string, url: string, body?: V): Observable<T> {
    return this.http.request<T>(httpMethod, url, {
      body: body
    });
  }

}
