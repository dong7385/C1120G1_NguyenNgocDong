import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // @ts-ignore
  public products: Product [] = [
    {name: 'iphone 12',price: 1200,productDate:'2021-4-12',quantity: 2,description:'American'},
    {name: 'iphone 10',price: 1000,productDate:'2021-1-12',quantity: 0,description:'Viet Nam'},
    {name: 'iphone 9',price: 800,productDate:'2020-2-12',quantity: 9,description:'Japan'},
    {name: 'iphone 8',price: 600,productDate:'2019-4-12',quantity: 15,description:'American'},
    {name: 'iphone 5',price: 200,productDate:'2019-4-12',quantity: 15,description:'American'},
  ]

  constructor() { }

  // @ts-ignore
  save(product: Product){
    this.products.unshift(product);
    console.log("save:"+ product)
  }

  getProductByIndex(index: number) {
    return this.products[index];
  }
}
