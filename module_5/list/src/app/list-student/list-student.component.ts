import { Component, OnInit } from '@angular/core';
export interface Istudent {
id: number;
name: string;
mark: number;
image: string;
}
@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
student: Istudent = {
  id: 1,
  name: 'Nguyen Van A',
  mark: 10,
  image: 'https://images.pexels.com/photos/1105218/pexels-photo-1105218.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'
};
  constructor() { }
  ngOnInit(): void {
  }

  getMark(value: any) {
    this.student.mark = value;
  }

  filter(value: any) {
    this.student.mark = value;
  }

  getMas(value: any) {
    this.student.mark=value;
  }
}
