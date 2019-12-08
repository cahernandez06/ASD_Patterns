package bank.service;

public class AccountDTO implements IAccount{
	
	long accountNumber;
	String customerName;
	double accountBalance;
	
	public AccountDTO(String customer, long number, double balance) {
		this.customerName = customer;
		this.accountNumber = number;
		this.accountBalance = balance;
	}

}
