import { Component, OnInit } from '@angular/core';
import { IUser } from './user';
import { UserService } from './user.service';

@Component({
    selector: 'print-transaction',
    templateUrl: './printComponent.html'
    
  })
  export class PrintTransactionComponent   {
   
    transaction: any;
    user:IUser;
    status:boolean=false;
   
    constructor(private userService: UserService) {
        this.user=new IUser();
        
    }
   
    onSubmit() {
      this.userService.printTransaction(this.user.username).subscribe(data => {
        this.transaction = data;
        console.log(this.transaction);
        this.status=!this.status;
      });
    }
  }