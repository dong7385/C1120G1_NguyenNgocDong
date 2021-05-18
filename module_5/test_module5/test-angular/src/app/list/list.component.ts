import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {StudentService} from "../sevice/student.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  // @ts-ignore
  studentList: Student [] = [];
  keySearch = "";
  optionSearch = 1;


  constructor(private _formBuilder: FormBuilder,
              private _studentService: StudentService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._studentService.findAll().subscribe(data => {
      this.studentList = data;
    }, error => {
      console.log(error)
    })
  }

  showDetail(product: any) {

  }

  searchProduct() {
    if (this.optionSearch == 1) {
      return this._studentService.search1(this.keySearch).subscribe(data => {
        this.studentList = data;
      })
    } else if (this.optionSearch == 2) {
      return this._studentService.search2(this.keySearch).subscribe(data => {
        this.studentList = data;
      })
    } else (this.optionSearch == 3)
    {
      return this._studentService.search3(this.keySearch).subscribe(data => {
        this.studentList = data;
      })
    }
  }
}
