import { Component } from '@angular/core';
import { IUser } from './user';
import { UserService } from './user.service';


@Component({
    selector: 'fund-transfer',
    templateUrl: './fundtransfer.component.html'
})

export class FundTransferComponent {
    user1: IUser;
    user2: IUser;
    user: IUser;
    public amount: number;
    balance: number;


    status: boolean = false;


    constructor(private userService: UserService) {
        this.user1 = new IUser();
        this.user2 = new IUser();
        this.user = new IUser();

    }

    onSubmit() {

        this.userService.fundTransfer(this.user1.username, this.user1.password, this.amount, this.user2.username).subscribe(data => {
        
            this.balance = data;

        });

        this.status = !this.status;


    }
}
