import { BrowserModule } from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminConsoleComponent } from './admin-console/admin-console.component';
import { UserDataWindowComponent } from './user-data-window/user-data-window.component';
import { ReactiveFormsModule } from '@angular/forms';

import { YaMapsComponent } from './ya-maps/ya-maps.component';
import { YamapngModule } from 'projects/yamapng/src/public_api';
import { YaCoreModule } from 'projects/yamapng/src/lib/core.module';
import {AppService} from "./service/service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {OrderDTO} from "./service/orderDTO";

@NgModule({
  declarations: [
    AppComponent,
    AdminConsoleComponent,
    UserDataWindowComponent,
    YaMapsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    YamapngModule ,
    YaCoreModule.forRoot({
      apiKey: 'f3e4969b-b166-42b5-835a-6f00ef94fb4f'
    }),
    HttpClientModule
  ],
  providers: [AppService, HttpClient, OrderDTO],
  bootstrap: [AppComponent]
})
export class AppModule { }
