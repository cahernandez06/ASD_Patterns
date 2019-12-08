package bank.emailService;

public class MockEmailSenderImpl implements IEmailSender{
	
	private static MockEmailSenderImpl emailSender;
	
	private MockEmailSenderImpl() {
		//To prevent two instance by using reflection
		if (emailSender!=null) {
			throw new RuntimeException("Use getEmailsender() method to get the single instance of this class.");
		}
	}

	public static MockEmailSenderImpl getEmailSender() {
		//To prevent two instances by multi-thread, solution 2
		if (emailSender==null) {
			synchronized (MockEmailSenderImpl.class) {
				if (emailSender==null)  emailSender = new MockEmailSenderImpl();
			}
		}
		return emailSender;
	}
	
	@Override
	public void sendEmail(String message) {
		System.out.println("Sending email from: " + this.getClass().getCanonicalName() + "\n");
	}

}
