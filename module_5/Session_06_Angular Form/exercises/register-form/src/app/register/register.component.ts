import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  public listCountry: string [] = ['VietNam', 'lao', 'thai lan', 'indonesia', 'malaysia'];
  rfRegister: FormGroup;
  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.rfRegister = this._formBuilder.group({
      name: ['', [Validators.required]],
      gender: ['', Validators.required],
      age: [0, [Validators.required, Validators.min(18), Validators.max(100)]],
      phone: ['', [Validators.required, Validators.pattern('^\\+84[0-9]{9,10}$')]],
      country: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['',[Validators.required, Validators.minLength(6)]],
    })
  }

  submitForm() {
    console.log(this.rfRegister.value)
  }
}
