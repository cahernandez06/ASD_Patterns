package bank.dao;

import java.util.ArrayList;
import java.util.Collection;

import bank.domain.Account;

public class MockDAOImpl implements IAccountDAO{
	
	Collection<Account> accListMock = new ArrayList<Account>();

	@Override
	public void saveAccount(Account account) {
		System.out.println("Saving account number: " + account.getAccountnumber() + " from: " + this.getClass().getCanonicalName());
		accListMock.add(account); // add the new
	}

	@Override
	public void updateAccount(Account account) {
		System.out.println("Updating account number: " + account.getAccountnumber() + " from: " + this.getClass().getCanonicalName());
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accListMock.remove(accountexist); // remove the old
			accListMock.add(account); // add the new
		}
		}

	@Override
	public Account loadAccount(long accountnumber) {
		System.out.println("Loading account number: " + accountnumber + " from: " + this.getClass().getCanonicalName());
		for (Account account : accListMock) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Collection<Account> getAccounts() {
		System.out.println("Returning accounts from: " + this.getClass().getCanonicalName());
		return accListMock;
	}

}
