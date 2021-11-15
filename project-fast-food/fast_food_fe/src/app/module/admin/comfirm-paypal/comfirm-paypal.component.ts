import { Component, OnInit } from '@angular/core';
import {CartService} from '../../../service/cart/cart.service';
import {Router} from '@angular/router';
import {Cart} from '../../../model/Cart';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-comfirm-paypal',
  templateUrl: './comfirm-paypal.component.html',
  styleUrls: ['./comfirm-paypal.component.css']
})
export class ComfirmPaypalComponent implements OnInit {

  cards: Cart[]=[];
  totalMoney: number = 0;

  constructor( private cartService: CartService,
               private router: Router,
               private toast: ToastrService
               ) { }

  ngOnInit(): void {
    this.sendNumberOfCartToHeader();
    this.getCart();
    this.totalMoneyOfFood();
  }


  sendNumberOfCartToHeader() {
    this.cartService.changeNumberCart(this.cards.length);
  }

  confirm() {
    this.toast.success("Thanh Toán Thành Công");
    localStorage.clear();
    this.router.navigateByUrl('/')
  }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log("get cart localSto" + this.cards);
  }
  totalMoneyOfFood() {
    console.log(this.cards);
    for (let i = 0; i < this.cards.length; i++) {
      this.totalMoney +=this.cards[i].food.foodPrice*this.cards[i].quantity;
    }
  }
}
