import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductService} from "../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  rfProduct: FormGroup;
  private id: number = 0;

  constructor(private _formBuilder: FormBuilder,
              private _productService: ProductService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this._activatedRoute.snapshot.params["id"];
    this.initForm();
    this._productService.findById(this.id).subscribe(data => {
      this.rfProduct.patchValue(data);
    })
  }

  initForm() {
    this.rfProduct = this._formBuilder.group({
      name: [''],
      price: [''],
      productDate: [''],
      quantity: [''],
      description: [''],
    });
  }

  onSubmit() {
    console.log(this.rfProduct.value);
    if (this.rfProduct.valid) {
      // @ts-ignore
      this._productService.update(this.rfProduct.value, this.id).subscribe(data => {
        this._router.navigateByUrl("")
      }, error => {
        console.log(error)
      });

    }
  }
}
