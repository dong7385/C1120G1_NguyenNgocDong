import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public API_URL = "http://localhost:3000/product";

  constructor(private _httpClient: HttpClient) {
  }
  // @ts-ignore
  findAll(): Observable<Product[]> {
    // @ts-ignore
    return this._httpClient.get<Product[]>(this.API_URL);
  }

  // @ts-ignore
  save(product: Product): Observable<Product> {
    // @ts-ignore
    return this._httpClient.post<Product>(this.API_URL, product)
  }

  // @ts-ignore
  findById(id: number): Observable<Product> {
    // @ts-ignore
    return this._httpClient.get<Product>(`${this.API_URL}/${id}`)
  }

  // @ts-ignore
  update(product: Product, id: number): Observable<Product> {
    // @ts-ignore
    return this._httpClient.put<Product>(`${this.API_URL}/${id}`, product);
  }
  // @ts-ignore
  delete(product: Product,id: number): Observable<Product> {
    // @ts-ignore
    return this._httpClient.delete<Product>(`${this.API_URL}/${id}`,product);
  }

  // @ts-ignore
  search1(keySearch: string): Observable<Product[]> {
    // @ts-ignore
    return this._httpClient.get<Product[]>(this.API_URL +"?name_like="+ keySearch);
  }  // @ts-ignore
  // @ts-ignore
  search2(keySearch: string): Observable<Product[]> {
    // @ts-ignore
    return this._httpClient.get<Product[]>(this.API_URL +"?quantity="+ keySearch);
  }
  // @ts-ignore
  search3(keySearch: string): Observable<Product[]> {
    // @ts-ignore
    return this._httpClient.get<Product[]>(this.API_URL +"?price="+ keySearch);
  }

}
