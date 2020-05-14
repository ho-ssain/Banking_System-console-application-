package Banking_System;

class SavingsAccount extends Account{

	SavingsAccount(String name ,float balance, int account_num){
		super(name , balance, account_num);
	}
	public float deposite(int amount){
		super.balance = super.balance + amount;
		return balance;
	}
	public void changeInterest(float inter){
		interest = inter;
	}
	public void addInterest(int year){
		for(int i = 1 ; i<=year ; i++){
			this.balance = balance + balance/100 * interest;
		}
	}
	public void withdraw(int amount){
		if((super.balance-amount)>=100){
			super.balance = super.balance-amount;
		}
		else{
			System.out.println("Must have at least 100$ amount remaining after withdrawal \nEnter a smaller amount");
		}
	}
	public void transfer(int amount) {}

	public void showAccount() {
		System.out.println("Account Holder name-: " + this.name);
		System.out.println("Account Type-: Savings");
		System.out.println("Account Balance-: " + this.balance);
	}
	
}