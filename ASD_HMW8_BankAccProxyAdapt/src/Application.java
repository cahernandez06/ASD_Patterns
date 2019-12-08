
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Iterator;

import bank.dao.IAccountDAO;
import bank.dao.StopWatchProxy;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.AccountSrv;
import bank.service.IAccount;

public class Application {
	public static void main(String[] args) {
		AccountSrv accountService = new AccountService();
		ClassLoader classLoader = IAccountDAO.class.getClassLoader();
		AccountSrv stopWatchProxySrv = (AccountSrv) Proxy.newProxyInstance(	classLoader, 
				  															new Class[] { AccountSrv.class}, 
				  															new StopWatchProxy(accountService));
		// 3 accounts;
		stopWatchProxySrv.createAccount(111111, "Carlos Hernandez");
		stopWatchProxySrv.createAccount(222222, "Tomas Hernandez");
		stopWatchProxySrv.createAccount(333333, "Marthica Ramirez");
		//use account 1;
		stopWatchProxySrv.deposit(111111, 1000);
		stopWatchProxySrv.deposit(111111, 800);
		stopWatchProxySrv.withdraw(111111, 200);
		//use account 2;
		stopWatchProxySrv.deposit(222222, 800);
		stopWatchProxySrv.transferFunds(222222, 111111, 100, "payment of invoice 123");
		//use account 3;
		stopWatchProxySrv.deposit(333333, 500);
		// show balances
		
		Collection<IAccount> accountlist = accountService.getAllAccounts();
		Iterator<IAccount> itAccounts = accountlist.iterator();
		
		Customer customer = null;
		while (itAccounts.hasNext()) {
			
			Account currAccount = (Account) itAccounts.next();
			
			customer = currAccount.getCustomer();
			System.out.println("Statement for Account: " + currAccount.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : currAccount.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					currAccount.getBalance());
		}
	}

}


