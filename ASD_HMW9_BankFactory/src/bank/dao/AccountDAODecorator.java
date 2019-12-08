package bank.dao;

import java.util.Collection;

import bank.domain.Account;

public abstract class AccountDAODecorator implements IAccountDAO{
	
	IAccountDAO whoIDecorateTo;
	
	public AccountDAODecorator(IAccountDAO whoIDecorateTo) {
		this.whoIDecorateTo = whoIDecorateTo;
	}
	
	public abstract void saveAccount(Account account);
	
	public abstract void updateAccount(Account account);
	
	public abstract Account loadAccount(long accountnumber);
	
	public abstract Collection<Account> getAccounts();

}
