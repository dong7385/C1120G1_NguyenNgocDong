import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  // @ts-ignore
  public productList: Product [] =[];

  constructor(private _productService: ProductService) { }

  ngOnInit(): void {
    this.productList= this._productService.products;
  }

  // @ts-ignore
  showDetail(product: Product) {

  }
}
