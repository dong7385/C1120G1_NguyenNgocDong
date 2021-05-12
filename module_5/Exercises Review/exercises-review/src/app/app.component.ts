import { Component } from '@angular/core';
// @ts-ignore
import {Product} from "./model/Product";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'exercises-review';
  // @ts-ignore
  public product: Product | undefined;
  public products: Product [] = [
    {name: 'iphone 12',price: 1200,productDate:'2021-4-12',quantity: 2,description:'American'},
    {name: 'iphone 10',price: 1000,productDate:'2021-1-12',quantity: 0,description:'Viet Nam'},
    {name: 'iphone 9',price: 800,productDate:'2020-2-12',quantity: 9,description:'Japan'},
    {name: 'iphone 8',price: 600,productDate:'2019-4-12',quantity: 15,description:'American'},
  ]

  showDetail(product: Product) {
    this.product=product;
  }

  onGetCreate(value: Product) {
    this.products.unshift(value);
  }
}
