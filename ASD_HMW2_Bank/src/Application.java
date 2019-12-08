
import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;

public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		// 3 accounts;
		accountService.createAccount(111111, "Carlos Hernandez");
		accountService.createAccount(222222, "Tomas Hernandez");
		accountService.createAccount(333333, "Paola de Hernandez");
		//use account 1;
		accountService.deposit(111111, 1000);
		accountService.deposit(111111, 800);
		accountService.withdraw(111111, 200);
		//use account 2;
		accountService.deposit(222222, 800);
		accountService.transferFunds(222222, 111111, 100, "payment of invoice 123");
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


