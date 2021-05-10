import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../model/Product';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  @Input("productDetail") productDetail: Product | undefined

  constructor() { }

  ngOnInit(): void {
  }

}
