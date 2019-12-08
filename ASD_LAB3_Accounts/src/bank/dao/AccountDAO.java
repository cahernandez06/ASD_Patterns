package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add new account
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove old one
			accountlist.add(account); // add new account
		}

	}

	public Account loadAccount(long accountnumber) {
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}