export class Calculator {
  private _num1: number;
  private _num2: number;
  private _math: any;
  private _result: number;


  constructor(num1: number, num2: number, math: any, result: number) {
    this._num1 = num1;
    this._num2 = num2;
    this._math = math;
    this._result = result;
  }

  get num1(): number {
    return this._num1;
  }

  set num1(value: number) {
    this._num1 = value;
  }

  get num2(): number {
    return this._num2;
  }

  set num2(value: number) {
    this._num2 = value;
  }

  get math(): any {
    return this._math;
  }

  set math(value: any) {
    this._math = value;
  }

  get result(): number {
    return this._result;
  }

  set result(value: number) {
    this._result = value;
  }
}
