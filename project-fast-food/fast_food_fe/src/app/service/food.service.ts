import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Food} from '../model/Food';
import {TokenStorageService} from './security/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  httpOptions: any;
  API_URL = 'http://localhost:8080/home';

  constructor(public httpClient: HttpClient,private tokenStorage: TokenStorageService) {
    this.httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
      , 'Access-Control-Allow-Origin': 'http://localhost:4200', 'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  getFoodList(page: number): Observable<any> {
    return this.httpClient.get<any>(this.API_URL + '/list' + '?page=' + page, this.httpOptions);
  }

  searchFoodList(keySearch: any,page: number): Observable<any> {
    return this.httpClient.get<any>(this.API_URL + '/searchKey' + '?keySearch=' +  keySearch + '&page=' + page, this.httpOptions);
  }

  getFoodById(id: number): Observable<any> {
    return this.httpClient.get<any>(this.API_URL + '/' + id, this.httpOptions);
  }
}
