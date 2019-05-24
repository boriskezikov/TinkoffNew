import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderDTO} from "../shared/orderDTO";

@Injectable()
export class AppService{

  constructor(private httpClient: HttpClient, private orderDTO: OrderDTO){}

  public postOrder(orderData: string[]): Observable<any>
  {
      return this.httpClient.post('localhost:8080/api', this.requestToOrderDTO(orderData));
  }

  private requestToOrderDTO(orderData: string[]){
    this.orderDTO = JSON.parse(JSON.stringify(orderData));
    return this.orderDTO;

  }

}
