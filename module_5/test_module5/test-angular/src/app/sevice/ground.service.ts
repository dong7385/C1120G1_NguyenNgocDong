import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GroundService {

  public API_URL = "http://localhost:8080/ground";

  constructor(private _httpClient: HttpClient) {
  }

  // @ts-ignore
  findAllType(): Observable<Ground[]> {
    // @ts-ignore
    return this._httpClient.get<Ground[]>(this.API_URL);
  }
}
