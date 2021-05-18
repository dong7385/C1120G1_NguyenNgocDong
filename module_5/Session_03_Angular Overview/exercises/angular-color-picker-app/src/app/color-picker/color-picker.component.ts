import { Component, OnInit } from '@angular/core';
import {inspect} from "util";
import colors = module

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  background = colors;
  constructor() { }

  ngOnInit(): void {
  }

}
