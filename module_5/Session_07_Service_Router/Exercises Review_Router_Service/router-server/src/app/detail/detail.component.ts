import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {
// @ts-ignore
  public productDetail: Product
  constructor(private _activatedRoute: ActivatedRoute,
              private _productService: ProductService) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id']
    console.log("Id nhan dc :"+index);
    this.productDetail = this._productService.getProductByIndex(index);
  }

}
