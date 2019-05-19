import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-user-data-window',
  templateUrl: './user-data-window.component.html',
  styleUrls: ['./user-data-window.component.css']
})
export class UserDataWindowComponent implements OnInit {

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

    console.log(this.userData.value);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.userData.controls[controlName];

    return control.invalid && control.touched;
  }

  private initForm() {
    this.userData = this.fb.group({
      phone: ['', [
        Validators.required
      ]
      ],
      currentLocation: ['', [
        Validators.required
      ]
      ],
      destination: ['', [
        Validators.required
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



