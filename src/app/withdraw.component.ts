import { Component } from '@angular/core';
import { IUser } from './user';
import { UserService } from './user.service';


@Component({
    selector: 'money-deposit',
    templateUrl: './withdrawComponent.html'
})

export class MoneyWithdrawComponent{
    user:IUser;
    public amount:number;
     balance:number;
    status:boolean=false;
    

    constructor(private userService: UserService) {
        this.user=new IUser();
    }

onSubmit() {
    
        this.userService.moneyWithdraw (this.user.username,this.user.password,this.amount).subscribe(data => {
            this.balance = data;
            });
            
            this.status=!this.status;
     

}}
 