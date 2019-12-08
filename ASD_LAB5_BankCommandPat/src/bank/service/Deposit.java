package bank.service;

public class Deposit implements ICommand{
	private IAccountService accountService;
	private long accountnumber;
	private double amount;
	
	public Deposit(IAccountService accountService,long accountnumber, double amount) {
		this.accountService=accountService;
		this.accountnumber=accountnumber;
		this.amount=amount;
	}

	public void execute() {
		accountService.deposit(accountnumber, amount);
		
	}

	public void undo() {
		accountService.withdraw(accountnumber, amount);		
	}

}