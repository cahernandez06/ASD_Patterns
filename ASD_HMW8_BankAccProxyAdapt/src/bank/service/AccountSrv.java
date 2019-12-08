package bank.service;

import java.util.Collection;

public interface AccountSrv {
	public abstract IAccount createAccount(long accountNumber, String customerName);
	public abstract void deposit(long accountNumber, double amount);
	public abstract void withdraw(long accountNumber, double amount);
	public abstract void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
	public abstract Collection<IAccount> getAllAccounts();
	public abstract IAccount getAccount(long accountNumber);
}
