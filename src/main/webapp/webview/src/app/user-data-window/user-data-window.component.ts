import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AppService} from "../service/service";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-user-data-window',
  templateUrl: './user-data-window.component.html',
  styleUrls: ['./user-data-window.component.css']
})
export class UserDataWindowComponent implements OnInit {

  userData: FormGroup;
  phoneRegex = '^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$';

  constructor(private fb: FormBuilder, private appService: AppService,
              private httpClient: HttpClient) {
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

  }

  isControlInvalid(controlName: string): boolean {
    const control = this.userData.controls[controlName];

    return control.invalid && control.touched;
  }

  private initForm() {
    this.userData = this.fb.group({
      phone: ['', [
        Validators.required, Validators.pattern(this.phoneRegex)
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

  private onAction(){

    this.appService.postOrder(this.userData.value);
    console.log(this.userData.value);

  }
}



