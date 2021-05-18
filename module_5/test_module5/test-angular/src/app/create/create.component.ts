import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StudentService} from "../sevice/student.service";
import {Router} from "@angular/router";
import {GroundService} from "../sevice/ground.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  rfStudent: FormGroup;
  // @ts-ignore
  grounds: Ground [] = [];

  constructor(private _formBuilder: FormBuilder,
              private _studentService: StudentService,
              private _groundService: GroundService,
              private _router: Router
  ) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm() {
    this.findAllType();
    this.rfStudent = this._formBuilder.group({
      name: ['Nguyen Van D', [Validators.required]],
      ground: ['', Validators.required],
      topic: ['javascript'],
      teacher: ['Hai'],
      email: ['abc@abc.com', [Validators.required, Validators.email]],
      phone: ['+841111111112', [Validators.required, Validators.pattern('^\\+84[0-9]{10,12}$')]],
    });
  }

  findAllType() {
    this._groundService.findAllType().subscribe(data => {
      this.grounds = data;
    }, error => {
      console.log(error)
    })
  }

  onSubmit() {
    console.log(this.rfStudent.value);

    if (this.rfStudent.valid) {
      // @ts-ignore
      for (let e of this.grounds) {
        if (e.id == this.rfStudent.value.ground) {
          this.rfStudent.value.ground = e;
        }
      }
      // @ts-ignore
      this._studentService.save(this.rfStudent.value).subscribe(data => {
        this._router.navigateByUrl("")
      }, error => {
        console.log("error")
      });

    }
  }
}

