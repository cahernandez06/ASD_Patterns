package bank;

import bank.dao.IAccountDAO;
import bank.emailService.IEmailSender;

public interface MyFactory {
	public IAccountDAO getAccountDAO();
	public IEmailSender getEmailSender();

}
