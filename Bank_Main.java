package Banking_System;
import java.util.*;

public class Bank_Main {
    //(Main fun starts)...............................................................................
    public static void main(String[] args) {
        ArrayList<SavingsAccount> savingsAccountsList = new ArrayList<>();
        ArrayList<CurrentAccount> currentAccountsList = new ArrayList<>();
        
      

        Scanner input = new Scanner(System.in);
        int c1, c2;
        String name;  
        float balance; 
        int Sav_accNum = 1000;
        int Curr_accNum = 1100;
        int accNum;
        int money;
        float interest;
        int year;

        while (true){
            
            System.out.println("...............................................");
            System.out.println("Please select from the following menu:");
            System.out.println("1. Add new account");
            System.out.println("2. Change Saving Interest Rate");
            System.out.println("3. Update balance with interest rate");
            System.out.println("4. Get number of currently active account");
            System.out.println("5. Find any account details");
            System.out.println("6. Deposit money into any account");
            System.out.println("7. Withdraw money from any account");
            System.out.println("8. Transfer Money");
            System.out.println("............Enter 0 to exit................... ");

            c1 = input.nextInt();
            switch(c1) {
              
                case 1://Creating a new account
                    System.out.println(".......................................");
                    System.out.println("Enter 1 for---Create Savings-Account");
                    System.out.println("Enter 2 for---Create Current-Account");
                    c2 = input.nextInt();
                    
                    System.out.print("Enter name : ");
                    input.nextLine();
                    name = input.nextLine();
                    System.out.print("Enter Balance : ");
                    balance = input.nextFloat();
                    if(c2 == 1){
                    
                        SavingsAccount s_ob = new SavingsAccount(name, balance, Sav_accNum);
                        savingsAccountsList.add(s_ob);
                        System.out.println("Account Created successfully with account Number- " + Sav_accNum);
                        Sav_accNum = Sav_accNum + 1;
                    }
                    else if(c2 == 2){
                   
                        CurrentAccount c_ob = new CurrentAccount(name, balance, Curr_accNum);
                        currentAccountsList.add(c_ob);
                        System.out.println("Account Created successfully with account Number- " + Curr_accNum);
                        Curr_accNum = Curr_accNum + 1;
                    }
                    else{
                        System.out.println(" Wrong Option !!!");
                    }
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;

                case 2 ://Change interest
                    System.out.println("Enter new interest rate-: ");
                    interest = input.nextFloat();
                    Account.interest = interest;
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;

                case 3 ://update balance
                    System.out.println("Updating Balance(with interest)-: ");
                    System.out.println("Enter account number-: ");
                    accNum = input.nextInt();
                    System.out.println("Enter Year number-: ");
                    year = input.nextInt();
                    for (int i = 0; i < savingsAccountsList.size(); i++) {
                        SavingsAccount ob = savingsAccountsList.get(i);
                        
                        if(ob.account_num == accNum) {
                            ob.addInterest(year);
                            System.out.println("Your new balance is -: " + ob.balance);
                            break;    
                        }
                    }
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;
                case 4://Get number of currently active account
                    int count = 0;
              
                    for (SavingsAccount savingAccount : savingsAccountsList) {
                        count++;
                    }
                    for (CurrentAccount currentAccount : currentAccountsList) {
                        count++;
                    }
                    System.out.println("Total currently activated account is -: " + count);
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;
                case 5://Find any account details
                    System.out.print("Enter account Number--: ");
                    accNum = input.nextInt();
                    
          
                    for (int i = 0; i < savingsAccountsList.size(); i++) {
                        SavingsAccount ob = savingsAccountsList.get(i);
                        if(ob.account_num == accNum) {
                            ob.showAccount();
                            break;    
                        }
                        
                    }
                    for (int i = 0; i < currentAccountsList.size(); i++) {
                        CurrentAccount ob1 = currentAccountsList.get(i);
                        if(ob1.account_num == accNum){
                            ob1.showAccount();
                            break;    
                        }
                    }
                    
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;
                case 6://Deposit money into any account
                    System.out.print("Enter account number--: ");
                    accNum = input.nextInt();
                    System.out.print("Enter deposit money--: ");
                    money = input.nextInt();
            
                    for (int i = 0; i < savingsAccountsList.size(); i++) {
                        SavingsAccount ob = savingsAccountsList.get(i);
                        if(ob.account_num == accNum) {
                            ob.deposite(money);
                            System.out.println("Your new balance is -: " + ob.balance);
                            break;    
                        } 
                    }
                    for (int i = 0; i < currentAccountsList.size(); i++) {
                        CurrentAccount ob1 = currentAccountsList.get(i);
                        if(ob1.account_num == accNum) {
                            ob1.deposite(money);
                            System.out.println("Your new balance is -: " + ob1.balance);
                            break;  
                        }
                    }
                    
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;
                case 7:// Withdraw money from any account
                    System.out.print("Enter your account number-: ");
                    accNum = input.nextInt();
                    System.out.print("How much money do you want to Withdraw? Enter-: ");
                    money = input.nextInt();
                
                    for (int i = 0; i < savingsAccountsList.size(); i++) {
                        SavingsAccount ob = savingsAccountsList.get(i);
                        if(ob.account_num == accNum) {
                            ob.withdraw(money);
                            System.out.println("Your withdraw balance is-: " + money);
                            System.out.println("Your current balance is -: " + ob.balance);
                            break;    
                        }
                    }
                    for (int i = 0; i < currentAccountsList.size(); i++) {
                        CurrentAccount ob1 = currentAccountsList.get(i);
                        if(ob1.account_num == accNum) {
                            ob1.withdraw(money);
                            System.out.println("Your withdraw balance is-: " + money);
                            System.out.println("Your current balance is -: " + ob1.balance);
                            break;  
                        }
                    }
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;
                case 8://Transfer money from one account to another
                    System.out.print("Enter your account number-: ");
                    accNum = input.nextInt();
                    System.out.print("Enter Transfer amount-: ");
                    money = input.nextInt();
                
                    for (int i = 0; i < savingsAccountsList.size(); i++) {
                        SavingsAccount ob = savingsAccountsList.get(i);
                        if(ob.account_num == accNum) {
                            ob.transfer(money);
                            System.out.println("You have transfered money");
                            System.out.println("Your current balance is " + ob.balance);
                            break;    
                        }
                    }
                    for (int i = 0; i < currentAccountsList.size(); i++) {
                        CurrentAccount ob1 = currentAccountsList.get(i);
                        if(ob1.account_num == accNum) {
                            ob1.transfer(money);
                            System.out.println("You have transfered money");
                            System.out.println("Your current balance is " + ob1.balance);
                            break;  
                        }
                    }
                 
                    System.out.print("To Continue enter any key-:");
                    input.next();
                    break;

            }
        }

    }
    
}


