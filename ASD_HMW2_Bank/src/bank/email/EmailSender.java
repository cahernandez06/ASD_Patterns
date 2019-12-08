package bank.email;


import java.util.Date;

import bank.domain.Account;

public class EmailSender {
	
	public void sendEmail(String emailInfo) {
		Date dateMessage = new Date();
		System.out.println("sending an email and the information is: " + emailInfo + " -- " + dateMessage);
	}

	public void update(Long accountNumber) {
		
		if (accountNumber == 0.0) {
			Account account = new Account(accountNumber);
			Long newAccountNumber = account.getAccountnumber();
			double balance = account.getBalance();
			String emailInfo = "Account: " + newAccountNumber + " an account has been created and the balance is = " + balance;
			sendEmail(emailInfo);
		}
	}
}
