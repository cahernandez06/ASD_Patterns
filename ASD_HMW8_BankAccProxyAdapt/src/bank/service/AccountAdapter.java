package bank.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import bank.domain.Account;

public class AccountAdapter implements AccountSrv{

	private AccountSrv target;
	
	public AccountAdapter() {
		this.target = new AccountService();
	}

	@Override
	public void deposit(long accountNumber, double amount) {
		target.deposit(accountNumber, amount);
	}

	@Override
	public void withdraw(long accountNumber, double amount) {
		target.withdraw(accountNumber, amount);
	}

	@Override
	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		target.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
	}

	@Override
	public IAccount createAccount(long accountNumber, String customerName) {
		Account newAccount;
		
		//Transform from Account to AccountDTO
		newAccount = (Account) target.createAccount(accountNumber, customerName);
		
		AccountDTO newAccountDTO = new AccountDTO(	newAccount.getCustomer().getName(), 
				 									newAccount.getAccountnumber(), 
				 									newAccount.getBalance());
		return newAccountDTO;
	}
	
	@Override
	public Collection<IAccount> getAllAccounts() {
		Collection<IAccount> allIAccounts;
		Collection<IAccount> respAccounts = new ArrayList<IAccount>();
		
		allIAccounts = target.getAllAccounts();
		Iterator<IAccount> itAccounts = allIAccounts.iterator();
		
		while (itAccounts.hasNext()) {
			Account tmpAcc = (Account) itAccounts.next();
			AccountDTO newAccountDTO = new AccountDTO(	tmpAcc.getCustomer().getName(), 
														tmpAcc.getAccountnumber(), 
														tmpAcc.getBalance());
			respAccounts.add(newAccountDTO);
		}
		return respAccounts;
	}

	
	@Override
	public IAccount getAccount(long accountNumber) {
		Account newAccount;
		
		//Transform from Account to AccountDTO
		newAccount = (Account) target.getAccount(accountNumber);
		
		AccountDTO newAccountDTO = new AccountDTO(	newAccount.getCustomer().getName(), 
				 									newAccount.getAccountnumber(), 
				 									newAccount.getBalance());
		return newAccountDTO;
	}
	
}
