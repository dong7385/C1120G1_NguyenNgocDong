import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HomeComponent} from '../home/home.component';
import {DataService} from '../../service/data/data.service';
import {CartService} from '../../service/cart/cart.service';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {AuthService} from '../../service/security/auth.service';
import Swal from 'sweetalert2';

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

  private roles: string[];
  isLoggedIn = false;
  username: string;
  image: string;
  private Swal: any;



  constructor(private router: Router,
              private homeComponent: HomeComponent,
              private data: DataService,
              private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private authService: AuthService
              ) { }

  ngOnInit(): void {
    this.receiveDataFromFoodList();
    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.isLoggedIn = !!this.tokenStorageService.getToken();
      this.roles = user.roles;
      this.username = user.username;
    }
  }
  logout() {
    Swal.fire({
      title: 'Bạn có muốn đăng suất ' + this.username + ' ?',
      icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý',
      cancelButtonText: 'Hủy',
      allowOutsideClick: false,
      confirmButtonColor: '#DD6B55',
      cancelButtonColor: '#768394'
    }).then((result) => {
      if (result.value) {
        this.authService.logout(this.tokenStorageService.getUser().employee.employeeId).subscribe();
        this.tokenStorageService.signOut();
        window.location.href = 'http://localhost:4200';
      } else if (result.dismiss === this.Swal.DismissReason.cancel) {
      }
    });
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
