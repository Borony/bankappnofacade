/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;
import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;
/**
 *
 * @author sarun
 */
public class BankFacade {
    /**
     * @param args the command line arguments
     */
    static private CustomerIf bankCustomer1;
    static private CustomerIf bankCustomer2;
    public BankFacade() {
        ArrayList<AccountIf> cust1Accounts = new ArrayList();
        cust1Accounts.add(new BankAccount(1));
        cust1Accounts.add(new BankAccount(2));
        bankCustomer1 = new BankCustomer("Ice", cust1Accounts);
        ArrayList<AccountIf> cust2Accounts = new ArrayList();
        cust2Accounts.add(new BankAccount(3));
        cust2Accounts.add(new BankAccount(4));
        bankCustomer2 = new BankCustomer("Fam", cust2Accounts);
}
    public void doDeposit(double amt, CustomerIf cust, int accNo) {
        cust.getAccount(accNo).deposit(amt);
    }
    public void getBankAccount(CustomerIf cust, int accNo) {
        AccountIf acc = cust.getAccount(accNo);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
    }
    public void getBanCustomer(String custName) {
    if (bankCustomer1.getCustomerName().equals(custName)) {
        ArrayList<AccountIf> accounts = bankCustomer1.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + bankCustomer1.getCustomerName());
        System.out.println("Has " + bankCustomer1.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
    } else if (bankCustomer2.getCustomerName().equals(custName)) {
        ArrayList<AccountIf> accounts = bankCustomer2.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + bankCustomer2.getCustomerName());
        System.out.println("Has " + bankCustomer2.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
    }
}
    public static void main(String[] args) {
       /* ArrayList<AccountIf> cust1Accounts = new ArrayList();
        AccountIf acc = new BankAccount(12345);
        acc.deposit(500);
        cust1Accounts.add(acc);
        acc = new BankAccount(12346);
        acc.deposit(1000);
        cust1Accounts.add(acc);
        CustomerIf cust1 = new BankCustomer("John", cust1Accounts);
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust1.getCustomerName());
        System.out.println("Has " + cust1.getNumAccounts() + " accounts");
        acc = cust1.getAccount(12345);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
        acc = cust1.getAccount(12346);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
        acc.deposit(1000);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
        ArrayList<AccountIf> accounts = cust1.getllAccounts();
        for(AccountIf account : accounts) {
         System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());  
                 }   */
       BankFacade bf = new BankFacade();
       bf.doDeposit(500,bankCustomer1,1);
       bf.doDeposit(200,bankCustomer1,2); 
       bf.getBankAccount(bankCustomer1,2);
       bf.getBanCustomer("Ice");
       bf.doDeposit(1000,bankCustomer2,3);
       bf.doDeposit(150,bankCustomer2,4); 
       bf.getBankAccount(bankCustomer2,3);
       bf.getBanCustomer("Fam");
    }
}