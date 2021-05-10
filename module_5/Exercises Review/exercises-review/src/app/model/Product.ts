export class Product {
  private _name: string;
  private _price: number;
  private _productDate: string;
  private _quantity: number;
  private _description: string;


  constructor(name: string, price: number, productDate: string, quantity: number, description: string) {
    this._name = name;
    this._price = price;
    this._productDate = productDate;
    this._quantity = quantity;
    this._description = description;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get productDate(): string {
    return this._productDate;
  }

  set productDate(value: string) {
    this._productDate = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }
}
