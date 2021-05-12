import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  rfProduct: FormGroup;
  // @ts-ignore
  editProduct: Product;
  constructor(private _formBuilder: FormBuilder,
              private _productService: ProductService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.rfProduct = this._formBuilder.group({
      name: [''],
      price: [''],
      productDate: [''],
      quantity: [''],
      description: [''],
    });
    let index = this._activatedRoute.snapshot.params['id']
    console.log("Id nhan dc :"+index);
    this.editProduct = this._productService.getProductByIndex(index);
  }

  onSubmit() {
    console.log(this.rfProduct.value);
    if (this.rfProduct.valid) {
      this._productService.save(this.rfProduct.value);
      this._router.navigateByUrl("/home")
    }
  }
}
