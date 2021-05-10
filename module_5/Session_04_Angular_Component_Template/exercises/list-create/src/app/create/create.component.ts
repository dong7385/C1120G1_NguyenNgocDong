import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../model/Student";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  @Output('studentCreate') onCreate= new EventEmitter <Student>()
  constructor() { }
  public student: Student | undefined;

  ngOnInit(): void {
  }
  create(name: string,gender: string,point: string){
    this.student= new Student(name,parseInt(gender),parseInt(point))
    console.log(this.student);
    this.onCreate.emit(this.student);
  }

}
