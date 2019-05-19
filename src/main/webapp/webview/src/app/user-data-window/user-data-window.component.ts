import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-user-data-window',
  templateUrl: './user-data-window.component.html',
  styleUrls: ['./user-data-window.component.css']
})
export class UserDataWindowComponent implements OnInit{

  //
  // OrderData = new FormGroup({
  //     phone: new FormControl('',
  //       Validators.pattern(/^[A-z0-9]*$/),),
  //     currentLocation: new FormControl('',
  //       Validators.pattern(/^[A-z0-9]*$/)),
  //     destination: new FormControl(''),
  //     type: new FormControl('',
  //       Validators.pattern(/^[A-z0-9]*$/))
  //   }
  // );

  userData: FormGroup;
  phoneRegex = '';

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  onSubmit() {
    const controls = this.userData.controls;

    if (this.userData.invalid) {
      Object.keys(controls)
        .forEach(controlName => controls[controlName].markAsTouched());

      return;
    }

    /** TODO: Обработка данных формы */
    console.log(this.userData.value);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.userData.controls[controlName];

    const result = control.invalid && control.touched;

    return result;
  }

  private initForm() {
    this.userData = this.fb.group({
      phone: ['', [
        Validators.required,
        Validators.pattern(this.phoneRegex)
      ]
      ],
      currentLocation: ['', [
        Validators.required
      ]
      ],
      destination: ['', [
        Validators.required, Validators.email
      ]
      ],
      taxiType: ['', [
        Validators.required
      ]
      ],
      email: ['', [
        Validators.required, Validators.email
      ]
      ]
    });
  }
}



