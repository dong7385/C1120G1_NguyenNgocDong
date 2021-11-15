import { Component, OnInit } from '@angular/core';
import {CartService} from '../../../service/cart/cart.service';

@Component({
  selector: 'app-comfirm-paypal',
  templateUrl: './comfirm-paypal.component.html',
  styleUrls: ['./comfirm-paypal.component.css']
})
export class ComfirmPaypalComponent implements OnInit {

  cards:any;
  constructor( cartService: CartService) { }

  ngOnInit(): void {
    this.getCart();
    console.log("ssssssssssss"+this.cards);
  }

  getCart() {
    this.cards = this.cards.getItems();
    console.log("get cart localSto" + this.cards);
  }

}
