import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  rfProduct: FormGroup;
  // @ts-ignore
  constructor(private _formBuilder: FormBuilder,
              private _productService: ProductService,
              private _router: Router
  ) {
  }

  ngOnInit(): void {

    this.rfProduct = this._formBuilder.group({
      name: ['Laptop'],
      price: ['200'],
      productDate: ['Laptop'],
      quantity: ['3'],
      description: ['Japan'],
    });
  }

  onSubmit() {
    console.log(this.rfProduct.value);
    if (this.rfProduct.valid) {
      this._productService.save(this.rfProduct.value).subscribe(data=>{
        this._router.navigateByUrl("/home")
      },error => {
        console.log("error")
      });

    }
  }
}
