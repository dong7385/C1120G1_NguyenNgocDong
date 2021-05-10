import { Component } from '@angular/core';
import {Product} from './model/Product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'exercises-review';
  // @ts-ignore
  public products: Product [] = [
    new Product('iphone 12',1200,'2021-4-12',2,'American'),
    new Product('iphone 11',1000,'2021-1-1',9,'England'),
    new Product('iphone 10',800,'2020-1-12',20,'China'),
    new Product('iphone 8',500,'2019-1-12',0,'VietNam'),
  ]
  product: Product | undefined;

  showDetail(product: Product) {
    this.product=product;
  }

  onGetCreate(value: Product) {
    this.products.unshift(value);
  }
}
