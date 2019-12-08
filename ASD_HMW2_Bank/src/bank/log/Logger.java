package bank.log;

import java.util.Date;

import bank.domain.Account;

public class Logger {

	public void log(String logInfo) {
		Date dateLog = new Date();
		System.out.println("log information" + dateLog + " -- " + dateLog);
	}

	public void update(Account account) {
		Long accountNumber = account.getAccountnumber();
		double balance = account.getBalance();
		String logInfo = "Account: " + accountNumber + " was updated and the new balance is = " + balance;
		log(logInfo);
	}
}
