package bank.service;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import bank.dao.AccountDAOImpl;
import bank.dao.IAccountDAO;
import bank.dao.LoggingProxy;
import bank.dao.StopWatchProxy;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements AccountSrv{
	
	IAccountDAO accountDAOImpl = new AccountDAOImpl();
	ClassLoader classLoader = IAccountDAO.class.getClassLoader();
	
	IAccountDAO loggingProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader, 
														new Class[] { IAccountDAO.class}, 
														new LoggingProxy(accountDAOImpl));
	
	IAccountDAO stopWatchProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader, 
														  new Class[] { IAccountDAO.class}, 
														  new StopWatchProxy(loggingProxy));

	public void deposit(long accountNumber, double amount) {
		Account account = stopWatchProxy.loadAccount(accountNumber);
		account.deposit(amount);
		stopWatchProxy.updateAccount(account);
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = stopWatchProxy.loadAccount(accountNumber);
		account.withdraw(amount);
		stopWatchProxy.updateAccount(account);
	}
	
	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = stopWatchProxy.loadAccount(fromAccountNumber);
		Account toAccount = stopWatchProxy.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		stopWatchProxy.updateAccount(fromAccount);
		stopWatchProxy.updateAccount(toAccount);
	}
	
	public IAccount createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		stopWatchProxy.saveAccount(account);
		return account;
	}
	
	public Collection<IAccount> getAllAccounts() {
		Collection<Account> allAccounts;
		Collection<IAccount> respAccounts = new ArrayList<IAccount>();
		
		allAccounts = stopWatchProxy.getAccounts();
		Iterator<Account> itAccounts = allAccounts.iterator();
		
		while (itAccounts.hasNext()) {
			Account tmpAcc = (Account) itAccounts.next();
			respAccounts.add(tmpAcc);
		}
		return respAccounts;

	}
	
	public IAccount getAccount(long accountNumber) {
		Account account = stopWatchProxy.loadAccount(accountNumber);
		return account;
	}

}

