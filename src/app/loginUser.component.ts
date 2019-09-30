import { Component } from "@angular/core";
import {FormBuilder ,FormGroup, FormArray, FormControl, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import { IUser } from "./user";
import {UserService } from "./user.service";

@Component({
    selector: 'user-login',
    templateUrl: './loginUser.html'
})

export class loginUserComponent{

    user: IUser;
    result:boolean;
 
  constructor(private route: ActivatedRoute, private router:Router, 
    private userService :UserService) {
      this.user=new IUser();
    
  }
 
  onSubmit() {
    
  this.userService.login(this.user.username,this.user.password).subscribe(data => {this.result=data;console.log(this.result);
    if(this.result==true)
    {
      this.router.navigate(['/bankservices']);
    }
    else
    {
      this.router.navigate(['/loginuser']);
      alert("Invalid credentials");
    }
 
  
});
  
  }}