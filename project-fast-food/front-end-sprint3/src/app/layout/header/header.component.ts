import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HomeComponent} from '../home/home.component';
import {DataService} from '../../service/data/data.service';
import {CartService} from '../../service/cart/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  defaultImgUrl = 'https://seeklogo.com/images/F/fastfood-logo-D673849A4C-seeklogo.com.png';
  keySearch: string ="";
  page = 0;
  numberOfCart: number;
  constructor(private router: Router,
              private homeComponent: HomeComponent,
              private data: DataService,
              private cartService: CartService
              ) { }

  ngOnInit(): void {
    this.receiveDataFromFoodList();
  }

  receiveDataFromFoodList() {
    this.cartService.currentNumberCart.subscribe(data => {
      this.numberOfCart = data;
    });
  }
  search() {
    console.log(this.keySearch)
    this.data.changeKeySearch(this.keySearch);
  }

  setPage() {
    this.data.changeNumberPage(this.page);
  }
}
