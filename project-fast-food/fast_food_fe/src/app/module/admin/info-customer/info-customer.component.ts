import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {FoodService} from '../../../service/food.service';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {Customer} from '../../../model/Customer';

@Component({
  selector: 'app-info-customer',
  templateUrl: './info-customer.component.html',
  styleUrls: ['./info-customer.component.css']
})
export class InfoCustomerComponent implements OnInit {
  username: string;
  customer: Customer;

  constructor(private toast: ToastrService,
              private router: Router,
              private foodService: FoodService,
              private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    this.username = this.tokenStorage.getUser().username;
    console.log(this.username);
    this.getInfoCustomer();
  }

  getInfoCustomer() {
    this.foodService.getInfoCustomer(this.username).subscribe(data => {
      this.customer=data;
      console.log(this.customer);
      // this.toast.success('Truy Cập Thành Công',"Thông Tin Khách Hàng");
    },error => (
      this.toast.error("Cập Nhật Thông Tin Không Thành Công")
    ));
  }
}
