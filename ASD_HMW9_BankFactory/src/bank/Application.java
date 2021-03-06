package bank;

import java.util.Collection;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.emailService.IEmailSender;
import bank.service.AccountService;
import bank.service.IAccountService;

public class Application {
	public static void main(String[] args) {
		//Set which Factory has to use checking the config.properties file
		DAOFactory mainFactory = new DAOFactory();
		MyFactory factory = mainFactory.getFactory();
		
		//As per environment, sets the correct AccountDAO Factory: Pdn or Test
		IAccountDAO accountDAO = factory.getAccountDAO();
		//As per environment, sets the correct EmailSender Factory: Pdn or Test
		IEmailSender emailService = factory.getEmailSender();
		
		IAccountService accountService = new AccountService(accountDAO,emailService);
		// create 2 accounts;
		accountService.createAccount(1263862, "Carlos Hernandez");
		accountService.createAccount(4253892, "Tomas Hernandez");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
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


