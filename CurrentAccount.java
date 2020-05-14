package Banking_System;

class CurrentAccount extends Account{

	CurrentAccount(String name , float balance, int account_num){
		super(name , balance, account_num);
	}
	public void changeInterest(float inter){
		interest = inter;
	}
	public void addInterest(int year){
		for(int i = 1 ; i<=year ; i++){
			super.balance = balance + balance/100 * interest;
		}
	}
	public float deposite(int amount){
		super.balance = super.balance+amount;
		return balance;
	}
	public void withdraw(int amount){
		this.balance = this.balance - amount;
	}
	public void transfer(int amount) {
		this.balance = this.balance - amount;
	}
	public void showAccount() {
		System.out.println("Account Holder name-: " + this.name);
		System.out.println("Account Type-: Current");
		System.out.println("Account Balance-: " + this.balance);
	}
	
}