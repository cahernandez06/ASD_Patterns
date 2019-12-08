package bank;

import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.dao.MockDAOImpl;
import bank.emailService.IEmailSender;
import bank.emailService.MockEmailSenderImpl;

public class MockFactory implements MyFactory{

	@Override
	public IAccountDAO getAccountDAO() {
		return new AccountDAOLogger(new MockDAOImpl());
	}

	@Override
	public IEmailSender getEmailSender() {
		IEmailSender emailSender = MockEmailSenderImpl.getEmailSender();
		return emailSender;
	}

}