import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // @ts-ignore
  // private _products: Product [] = [
  //   {name: 'iphone 12',price: 1200,productDate:'2021-4-12',quantity: 2,description:'American'},
  //   {name: 'iphone 10',price: 1000,productDate:'2021-1-12',quantity: 0,description:'Viet Nam'},
  //   {name: 'iphone 9',price: 800,productDate:'2020-2-12',quantity: 9,description:'Japan'},
  //   {name: 'iphone 8',price: 600,productDate:'2019-4-12',quantity: 15,description:'American'},
  //   {name: 'iphone 5',price: 200,productDate:'2019-4-12',quantity: 15,description:'American'},
  // ]

  public API_URL = "http://localhost:3000/product";

  constructor(private _httpClient: HttpClient) {
  }

  // @ts-ignore
  get products(): Observable<Product[]> {
    // @ts-ignore
    return this._httpClient.get<Product[]>(this.API_URL);
  }
;
// @ts-ignore
  save(product: Product): Observable<Product> {
    // @ts-ignore
    return this._httpClient.post<Product>(this.API_URL, product)
  }

  // @ts-ignore
  getProductByIndex(id: number): Observable<Product> {
    // @ts-ignore
    return this._httpClient.get<Product>(`${this.API_URL}/${id}`)
  }

  // @ts-ignore
  update(product: Product,id: number): Observable<Product> {
    // @ts-ignore
    return this._httpClient.put<Product>(`${this.API_URL}/${id}`, product);
  }
}
