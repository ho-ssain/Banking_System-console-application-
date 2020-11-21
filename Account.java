package Banking_System;

abstract class Account{
	String name;
	float balance;
	int account_num;
	static float interest = (float) 3.75f;
	
	
	Account(String name , float balance, int account_num){
		this.name = name;
		this.balance = balance;
		this.account_num = account_num;
	}

	abstract float deposite(int amount);

	abstract void withdraw(int amount);

	abstract void transfer(int amount);

	abstract void changeInterest(float interest);

	abstract void addInterest(int year);

	abstract void showAccount();

	
}
//helooo
