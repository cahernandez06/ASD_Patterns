package customers;

public class EmailSender implements IEmailSender {
	String outgoingMailServer = "smtp.acme.com";
	private ILogger logger; //= new Logger();  //We will use constructor injection

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}

	public EmailSender(ILogger logger) {
		this.logger = logger;
	}
	
}
