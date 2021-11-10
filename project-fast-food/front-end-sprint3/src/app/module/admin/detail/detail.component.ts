import {Component, OnInit} from '@angular/core';
import {FoodService} from '../../../service/food.service';
import {ToastrService} from 'ngx-toastr';
import {DataService} from '../../../service/data/data.service';
import {ActivatedRoute} from '@angular/router';
import {Food} from '../../../model/Food';
import {CartService} from '../../../service/cart/cart.service';
import {Cart} from '../../../model/Cart';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  food: Food;
  id: number;
  numberOfCart:number=0;
  quantity: number = 1;
  cards: Cart[]=[];

  constructor(private foodService: FoodService,
              private activatedRoute: ActivatedRoute,
              private cartService: CartService,
              private toast: ToastrService) {
    this.id = Number(this.activatedRoute.snapshot.params.id);
  }

  ngOnInit(): void {
    this.getFoodById();
    // this.getCart();
    // this.sendNumberOfCartToHeader();
    // this.receiveDataFromFoodList();
  }

  getFoodById() {
    console.log('this.id=' + this.id);
    this.foodService.getFoodById(this.id).subscribe(data => {
      this.food = data;
      // this.foodName = data.foodName;
      // this.foodPrice = data.foodPrice;
      // this.description_food = data.description_food;
      // this.imageFood = data.image;
      // this.address = data.address;
      // this.statusFoodName = data.statusFood.statusFoodName;
      // this.typeFoodName = data.typeFood.typeFoodName;
      // console.log('data detail ts= ' + this.foodName);
      // console.log('data detail ts= ' + this.imageFood);
    }, error => {
      console.log('GetInfoFood' + error + 'BackEnd');
    });
  }

  incrementQuantity() {
    this.quantity++;
  }

  decrementQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
  }

  addToCard(food: Food, quantity: number) {
    this.cartService.addToCart(food, quantity);
    this.receiveDataFromFoodList();
  }

  // sendNumberOfCartToHeader() {
  //   this.cartService.changeNumberCart(this.cards.length);
  // }

  receiveDataFromFoodList() {
    this.cartService.currentNumberCart.subscribe(data => {
      this.numberOfCart = data;
    });
  }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log('caaaaa=  ' + this.cards);
  }
}
