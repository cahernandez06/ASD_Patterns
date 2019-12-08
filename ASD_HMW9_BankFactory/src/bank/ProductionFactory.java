package bank;

import bank.dao.AccountDAOImpl;
import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.emailService.EmailSenderImpl;
import bank.emailService.IEmailSender;

public class ProductionFactory implements MyFactory{

	@Override
	public IAccountDAO getAccountDAO() {
		return new AccountDAOLogger(new AccountDAOImpl());
	}

	@Override
	public IEmailSender getEmailSender() {
		IEmailSender emailSender = EmailSenderImpl.getEmailSender();
		return emailSender;
	}

}
