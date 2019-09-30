import { Component } from '@angular/core';
import { IUser } from './user';
import { UserService } from './user.service';


@Component({
    selector: 'money-deposit',
    templateUrl: './depositComponent.html'
})

export class MoneyDepositComponent{
    user:IUser;
    public amount:number;
     balance:number;
    status:boolean=false;
    

    constructor(private userService: UserService) {
        this.user=new IUser();
    }

onSubmit() {
    
        this.userService.moneyDeposit(this.user.username,this.user.password,this.amount).subscribe(data => {
            this.balance = data;
            });
            
            this.status=!this.status;
     

}}
 