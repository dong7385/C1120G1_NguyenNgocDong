import {Component, Input, OnInit} from '@angular/core';
// @ts-ignore
import {Product} from '../model/Product';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  @Input("productDetail") productDetail: Product

  constructor() { }

  ngOnInit(): void {
  }

}
