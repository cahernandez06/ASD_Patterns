package bank.service;

import java.util.Collection;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.emailService.IEmailSender;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private IEmailSender emailService;
	
	public AccountService( IAccountDAO accountDAO, IEmailSender emailServ){
		this.accountDAO = accountDAO;
		this.emailService = emailServ;
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		emailService.sendEmail("Welcome to Bank!");
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		emailService.sendEmail("We received your deposit: $" + amount);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		emailService.sendEmail("You did a withdraw of: $" + amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		emailService.sendEmail("You did a transfer of: $" + amount);
	}
}
