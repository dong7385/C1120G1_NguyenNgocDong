import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  // @ts-ignore
  public productList: Product [] =[];

  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    // this.productList= this._productService.products;
    this._productService.products.subscribe(data=> {
      this.productList = data;
    },error => {
      console.log(error)
    })
  }

  // @ts-ignore
  showDetail(product: Product) {

  }
}
