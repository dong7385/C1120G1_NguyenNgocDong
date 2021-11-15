import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailComponent} from './detail/detail.component';
import {PaymentComponent} from './payment/payment.component';
import {CartService} from '../../service/cart/cart.service';
import {CartComponent} from './cart/cart.component';
import {ComfirmPaypalComponent} from './comfirm-paypal/comfirm-paypal.component';


// @ts-ignore
const routes: Routes = [
  // {
  //   path: 'detail/:id', component: DetailComponent
  // },
  {
    path: 'detail/:id', component: DetailComponent
  },
  {
    path: 'cart', component: CartComponent
  },
  {
    path: 'payment-success', component: ComfirmPaypalComponent
  },
  {
    path: 'payment/:id', component: PaymentComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
