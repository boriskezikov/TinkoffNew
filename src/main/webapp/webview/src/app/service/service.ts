import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AppService{

  constructor(private httpClient: HttpClient){}

  private url: string = 'localhost:8080/api';

  postOrder(order: JSON) {
      this.httpClient.post(this.url, order);
  }

}
