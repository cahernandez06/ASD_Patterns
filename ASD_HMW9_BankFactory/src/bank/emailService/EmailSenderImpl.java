package bank.emailService;

public class EmailSenderImpl implements IEmailSender{
	
	private static EmailSenderImpl emailSender;
	
	private EmailSenderImpl() {
		//To prevent two instance by using reflection
		if (emailSender!=null) {
			throw new RuntimeException("Use getEmailsender() method to get the single instance of this class.");
		}
	}

	public static EmailSenderImpl getEmailSender() {
		//To prevent two instances by multi-thread, solution 2
		if (emailSender==null) {
			synchronized (EmailSenderImpl.class) {
				if (emailSender==null)  emailSender = new EmailSenderImpl();
			}
		}
		return emailSender;
	}
	
	@Override
	public void sendEmail(String message) {
		System.out.println("Sending email from: " + this.getClass().getCanonicalName() + "\n");
	}

}
