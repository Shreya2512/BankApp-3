import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { Routes, RouterModule } from '@angular/router';



import { UserService } from './user.service';
import { AddUserComponent } from './adduser.component';

import { HttpClientModule } from '@angular/common/http';
import { loginUserComponent } from './loginuser.component';
import { BankServiceComponent } from './BankServices.component';
import { CheckBalanceComponent } from './CheckBalance.component';
import { MoneyDepositComponent } from './deposit.component';
import { MoneyWithdrawComponent } from './withdraw.component';
import { FundTransferComponent } from './fundtransfer.component';
import { PrintTransactionComponent } from './print.component';




const appRouts: Routes = [
  { path: './', component: AppComponent },
  { path: 'loginuser', component: loginUserComponent },
  { path: 'addusers', component: AddUserComponent },
  { path: 'bankservices', component: BankServiceComponent },
  { path: 'checkbalance', component: CheckBalanceComponent },
  { path: 'deposit', component: MoneyDepositComponent },
  { path: 'withdraw', component: MoneyWithdrawComponent },
  { path: 'transfer', component: FundTransferComponent },
  { path: 'print', component: PrintTransactionComponent }


]

@NgModule({
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(appRouts), ReactiveFormsModule, HttpClientModule],
  declarations: [AppComponent, AddUserComponent, PrintTransactionComponent,FundTransferComponent, loginUserComponent, MoneyWithdrawComponent, MoneyDepositComponent, BankServiceComponent, CheckBalanceComponent],

  bootstrap: [AppComponent],
  providers: [UserService]
})

export class AppModule { }