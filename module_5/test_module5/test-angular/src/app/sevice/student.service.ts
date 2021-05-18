import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  public API_URL = "http://localhost:8080/student";

  constructor(private _httpClient: HttpClient) {
  }
  // @ts-ignore
  findAll(): Observable<Student[]> {
    // @ts-ignore
    return this._httpClient.get<Student[]>(this.API_URL);
  }

  // @ts-ignore
  save(student: Student): Observable<Student> {
    // @ts-ignore
    return this._httpClient.post<Student>(this.API_URL, student);
  }

  // @ts-ignore
  findById(id: number): Observable<Student> {
    // @ts-ignore
    return this._httpClient.get<Student>(`${this.API_URL}/${id}`);
  }

  // @ts-ignore
  update(student: Student, id: number): Observable<Student> {
    // @ts-ignore
    return this._httpClient.put<Student>(`${this.API_URL}/${id}`, student);
  }
  // @ts-ignore
  delete(student: Student, id: number): Observable<Student> {
    // @ts-ignore
    return this._httpClient.delete<Student>(`${this.API_URL}/${id}`,student);
  }

  // @ts-ignore
  search1(keySearch: string): Observable<Student[]> {
    // @ts-ignore
    return this._httpClient.get<Student[]>(this.API_URL +"?name_like="+ keySearch);
  }  // @ts-ignore
  // @ts-ignore
  search2(keySearch: string): Observable<Student[]> {
    // @ts-ignore
    return this._httpClient.get<Student[]>(this.API_URL +"?phone_like="+ keySearch);
  }
  // @ts-ignore
  search3(keySearch: string): Observable<Student[]> {
    // @ts-ignore
    return this._httpClient.get<Student[]>(this.API_URL +"?topic_like="+ keySearch);
  }

}
