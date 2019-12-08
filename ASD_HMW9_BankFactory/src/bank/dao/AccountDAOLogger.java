package bank.dao;

import java.util.Collection;
import java.util.Date;

import bank.domain.Account;

public class AccountDAOLogger extends AccountDAODecorator{

	public AccountDAOLogger(IAccountDAO whoIDecorateTo) {
		super(whoIDecorateTo);
	}

	@Override
	public void saveAccount(Account account) {
		System.out.println("Logging a saveAccount on: " + account.getAccountnumber() + " on: " + new Date());
		whoIDecorateTo.saveAccount(account);
	}
	
	@Override
	public void updateAccount(Account account) {
		System.out.println("Logging an updateAccount on: " + account.getAccountnumber() + " on: " + new Date());
		whoIDecorateTo.updateAccount(account);
	}
	
	@Override
	public Account loadAccount(long accountnumber) {
		System.out.println("Logging a loadAccount on: " + accountnumber + " on: " + new Date());
		return whoIDecorateTo.loadAccount(accountnumber);
	}
	
	@Override
	public Collection<Account> getAccounts() {
		System.out.println("Logging a getAccounts on: " + new Date());
		return whoIDecorateTo.getAccounts();
	}
	
}
