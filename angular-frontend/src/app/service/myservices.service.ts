import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.prod';
import { Observable } from 'rxjs';

const MY_SERVICE_API = environment.backendURL+ '/api/';

@Injectable({
  providedIn: 'root'
})
export class MyservicesService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8',
      'Accept': 'application/json',
    })
  };


  delete(name : any){
    return this.http.post(MY_SERVICE_API +`delete-names/${name}`,this.httpOptions);
  }

  saveOrUpdate(myForm: any): Observable<any> {
    return this.http.post(MY_SERVICE_API + `new-names`, myForm,this.httpOptions);
  }

  listOfNames(): Observable<any> {
    return this.http.get(MY_SERVICE_API + 'list-names', this.httpOptions);
  }
}
