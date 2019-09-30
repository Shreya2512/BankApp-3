import {Injectable} from '@angular/core';
import{IUser} from './user';
import{ HttpClient, HttpHeaders} from '@angular/common/http';
import {FormBuilder ,FormGroup, FormArray, FormControl, Validators} from '@angular/forms';
import { Observable } from 'rxjs';

@Injectable()

export class UserService{
    private usersUrl: string;
    private usersUrl2: string;
    private usersUrl3: string;
    private usersUrl4: string;
    private usersUrl5: string;
    private usersUrl6: string;

    constructor(private http: HttpClient) {
        this.usersUrl = 'http://localhost:9090/users/';
        this.usersUrl2 = 'http://localhost:9090/users/deposit';
        this.usersUrl3 = 'http://localhost:9090/users/withdraw';
        this.usersUrl4 = 'http://localhost:9090/users/transfer';
        this.usersUrl5 = 'http://localhost:9090/users/check';
        this.usersUrl6 = 'http://localhost:9090/users/print';
      }
      
      public login(username:string,password:string): Observable<any> {
        return this.http.get<any>(this.usersUrl5+"/"+username+"/"+password);
      }
      public save(user: IUser) {
        return this.http.post<IUser>(this.usersUrl, user);
      }

      public viewBalance(username:string,password:string): Observable<any> {
        return this.http.get<any>(this.usersUrl+"/"+username+"/"+password);
      }
      
      public moneyDeposit(username:string,password:string,amount:number):Observable<any>
    {
     return this.http.get<any>(this.usersUrl2+"/"+username+"/"+password+"/"+amount);
     }
   
     public moneyWithdraw(username:string,password:string,amount:number):Observable<any>
     {
      return this.http.get<any>(this.usersUrl3+"/"+username+"/"+password+"/"+amount);
      }

      public fundTransfer(username:string,password:string,amount:number,username1:string):Observable<any>
      {
       return this.http.get<any>(this.usersUrl4+"/"+username+"/"+password+"/"+amount+"/"+username1);
       }

      public printTransaction(username:string)
      {
        return this.http.get<any>(this.usersUrl6+"/"+username);
      }
}