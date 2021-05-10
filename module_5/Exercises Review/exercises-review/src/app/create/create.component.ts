import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Product} from '../model/Product';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  @Output('productCreate') onCreate = new EventEmitter <Product>();

  constructor() {
  }

  public product: Product | undefined;

  ngOnInit(): void {
  }

  create(name: string, price: string, productDate: string, quantity: string, description: string) {
    this.product = new Product(name,parseInt(price),productDate,parseInt(quantity),description)
    this.onCreate.emit(this.product);
  }
}
