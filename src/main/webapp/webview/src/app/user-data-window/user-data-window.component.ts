import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AppService} from "../service/service";


@Component({
  selector: 'app-user-data-window',
  templateUrl: './user-data-window.component.html',
  styleUrls: ['./user-data-window.component.css']
})
export class UserDataWindowComponent implements OnInit {

  userData: FormGroup;
  phoneRegex = '^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$';

  constructor(private fb: FormBuilder, private appService: AppService,
             ) {
  }

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
    this.appService.postOrder(this.userData.value);
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.userData.controls[controlName];

    return control.invalid && control.touched;
  }

  private initForm() {
    this.userData = this.fb.group({
      phoneNumber: ['', [
        Validators.required, Validators.pattern(this.phoneRegex)
      ]
      ],

      // need to get location from yamap
      location: ['', [
        Validators.required
      ]
      ],
      destination: ['', [
        Validators.required
      ]
      ],
      // taxiType: ['', [
      //   Validators.required
      // ]
      // ],
      // email: ['', [
      //   Validators.required, Validators.email
      // ]
      // ]
      status: ['true'],
      name: [''],
    });
  }

}



