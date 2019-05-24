import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {OrderDTO} from "./orderDTO";

@Injectable()
export class AppService {

  constructor(private httpClient: HttpClient, private orderDTO: OrderDTO) {
  }

  private url: string = 'http://localhost:8080/api/';


  postOrder(order) {
    this.orderDTO = JSON.parse(JSON.stringify(order));
    this.httpClient.post<OrderDTO>(this.url, this.orderDTO).subscribe(

    );

  }

}
