import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  rfLoginForm: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }


  ngOnInit(): void {
    this.rfLoginForm = this._formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }

  onSubmit() {
    console.log(this.rfLoginForm.value);
      // @ts-ignore
    if (this.rfLoginForm.value.email == 'dong@abc.com' && this.rfLoginForm.value.password == '123456'){
      alert("Welcome:  " +this.rfLoginForm.value.email);
      }
  }
}
