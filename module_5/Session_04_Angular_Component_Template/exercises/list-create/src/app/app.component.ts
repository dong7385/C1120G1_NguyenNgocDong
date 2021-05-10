import { Component } from '@angular/core';
import {Student} from "./model/Student";
import validate = WebAssembly.validate;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'list-create';
  public studens: Student[] = [
    new Student('Nguyen Van A',0,50),
    new Student('Vip',1,60),
    new Student('Nguyen Van A',2,100),
    new Student('Vip',0,70)
  ]

  onGetStudent(value: Student) {
    this.studens.unshift(value);
  }
}
