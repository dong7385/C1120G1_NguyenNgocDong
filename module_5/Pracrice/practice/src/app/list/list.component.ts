import {Component, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  // @ts-ignore
  productList: Product [] = [];
  keySearch = "";
  optionSearch = 1;


  constructor(private _formBuilder: FormBuilder,
              private _productService: ProductService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._productService.findAll().subscribe(data => {
      this.productList = data;
    }, error => {
      console.log(error)
    })
  }

  showDetail(product: any) {

  }


  searchProduct() {
    if (this.optionSearch == 1) {
      return this._productService.search1(this.keySearch).subscribe(data => {
        this.productList = data;
      })
    }
    else if (this.optionSearch == 2){
      return this._productService.search2(this.keySearch).subscribe(data => {
        this.productList = data;
      })
    }
   else (this.optionSearch==3)
    {
      return this._productService.search3(this.keySearch).subscribe(data => {
        this.productList = data;
      })
    }
  }
}
