package banks.sms;

import java.util.Date;
import bank.domain.Account;

public class MSSender {
	
	public void SMSSender(String message) {	
		Date dateMessage = new Date();
		System.out.println("Sending a message and the message is: " + message + "at: " + dateMessage);
	}
	
	public void update(Account account) {
		Long accountNumber = account.getAccountnumber();
		double balance = account.getBalance();
		String message = "Account: " + accountNumber + " was updated and the new balance is = " + balance;
		SMSSender(message);
	}
}
