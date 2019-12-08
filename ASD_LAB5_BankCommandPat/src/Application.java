
import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.Deposit;
import bank.service.Command;
import bank.service.IAccountService;
import bank.service.TransferFunds;
import bank.service.Withdraw;


public class Application {
	
	public static void main(String[] args) {
		//create HistoryList
		Command historyList = new Command();
		
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(12345, "Carlos Hernandez");
		accountService.createAccount(56789, "Tomas Hernandez");
		//use account 1;
		Deposit depositCommand1 = new Deposit(accountService,12345, 200);
		depositCommand1.execute();
		historyList.addCommand(depositCommand1);

		Deposit depositCommand2 = new Deposit(accountService,12345, 500);
		depositCommand2.execute();
		historyList.addCommand(depositCommand2);

		Withdraw withdrawCommand1 = new Withdraw(accountService,12345, 300);
		withdrawCommand1.execute();
		historyList.addCommand(withdrawCommand1);

		//use account 2;
		Deposit depositCommand3 = new Deposit(accountService,56789, 600);
		depositCommand3.execute();
		historyList.addCommand(depositCommand3);

		TransferFunds transferFundsCommand1 = new TransferFunds(accountService,56789, 12345, 100, "Dad's beers");
		transferFundsCommand1.execute();
		historyList.addCommand(transferFundsCommand1);
		//undo
		historyList.undo();
		
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
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					         + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
