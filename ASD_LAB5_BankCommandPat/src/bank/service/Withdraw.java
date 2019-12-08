package bank.service;

public class Withdraw implements ICommand{
	private IAccountService accountService;
	private long accountnumber;
	private double amount;
	
	public Withdraw(IAccountService accountService,long accountnumber, double amount) {
		this.accountService=accountService;
		this.accountnumber=accountnumber;
		this.amount=amount;
	}

	public void execute() {
		accountService.withdraw(accountnumber, amount);
		
	}

	public void undo() {
		accountService.deposit(accountnumber, amount);		
	}

}