import { Component } from "@angular/core";
import {FormBuilder ,FormGroup, FormArray, FormControl, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import { IUser } from "./user";
import {UserService } from "./user.service";

@Component({
    selector: 'user-add',
    templateUrl: './addComponent.html'
})

export class AddUserComponent{

    user: IUser;
 
  constructor(private route: ActivatedRoute, private router:Router, 
    private userService :UserService) {
      this.user=new IUser();
    
  }
 
  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.meth());
    this.router.navigate(['/loginuser'])
  }
  meth(): void {
   console.log("Added Successfully");
  }
 
  

}