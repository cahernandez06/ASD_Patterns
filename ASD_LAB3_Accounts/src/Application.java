import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(12345, "Carlos Hernandez");
		accountService.createAccount(56789, "Tomas Hernandez");
		//use account 1;
		accountService.deposit(12345, 1000);
		accountService.deposit(12345, 800);
		accountService.withdraw(12345, 200);
		//use account 2;
		accountService.deposit(56789, 2000);
		accountService.transferFunds(56789, 12345, 700, "Loan for rent");
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}

