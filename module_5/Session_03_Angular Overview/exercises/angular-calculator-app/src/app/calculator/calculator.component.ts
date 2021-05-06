import {Component, OnInit} from '@angular/core';
import {Calculator} from "../model/calculator";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  public calculator: Calculator = new Calculator(0, 0, '+', 0);
  public math: any;

  constructor() {
  }

  ngOnInit(): void {
  }

  total() {
    switch (this.math) {
      case '+':
        this.calculator.result = this.calculator.num1 + this.calculator.num2;
        break;
    }
  }
}
