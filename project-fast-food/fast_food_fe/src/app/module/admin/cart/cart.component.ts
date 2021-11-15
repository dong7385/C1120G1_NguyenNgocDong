import {Component, DoCheck, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart/cart.service';
import {Cart} from '../../../model/Cart';
import {ToastrService} from 'ngx-toastr';
import {PaymentService} from '../../../service/payment/payment.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cards: Cart[]=[];
  numberCart: any;
  totalMoney: number = 0;


  constructor(private cartService: CartService, private toast: ToastrService, public paymentService: PaymentService,) {
  }


  ngOnInit(): void {
    this.getCart();
    this.sendNumberOfCartToHeader();
    this.totalMoneyOfFood();
  }

  sendNumberOfCartToHeader() {
    this.cartService.changeNumberCart(this.cards.length);
  }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log('caaaaa=  ' + this.cards);
  }

  deleteOrderFood() {
    this.cartService.removeCartById();
  }

  totalMoneyOfFood() {
    console.log(this.cards);
    for (let i = 0; i < this.cards.length; i++) {
      this.totalMoney +=this.cards[i].food.foodPrice*this.cards[i].quantity;
    }
  }
  showInfoView() {

  }

  payPal(totalMoney: any) {
    localStorage.setItem("orderId", String(this.cards));
    this.paymentService.payment(totalMoney).subscribe(value => {
      console.log(value)
      // window.open(value.link)
      // @ts-ignore
      window.location.href = value.link;
    })
  }
}
