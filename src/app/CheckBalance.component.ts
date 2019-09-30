import { Component } from "@angular/core";
import {FormBuilder ,FormGroup, FormArray, FormControl, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import { IUser } from "./user";
import {UserService } from "./user.service";

@Component({
  selector: 'show-balance',
  templateUrl: './CheckBalance.html'
})

export class CheckBalanceComponent{

  user: IUser;
  balance:number;
  status:boolean=false;

constructor(private route: ActivatedRoute, private router:Router, 
  private userService :UserService) {
    this.user=new IUser();
  
}

onSubmit() {
  this.userService.viewBalance(this.user.username,this.user.password).subscribe(data => 
    {this.balance=data}
    
    );
    // this.router.navigate(['/checkbalance'])
    this.status=!this.status;
}


}