import {FormBuilder, FormGroup} from '@angular/forms';
import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  rfProduct: FormGroup;
  @Output('productCreate') onCreate = new EventEmitter<Product>();

  constructor(private _formBuilder: FormBuilder) {
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
    this.onCreate.emit(this.rfProduct.value);
  }
}
