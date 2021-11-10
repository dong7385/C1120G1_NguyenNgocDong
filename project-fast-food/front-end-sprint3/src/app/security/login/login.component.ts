import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  defaultImgUrl = 'https://www.dulichvtv.vn/wp-content/uploads/dimsum-trung-quoc.png';
  constructor() { }

  ngOnInit(): void {
  }

}
