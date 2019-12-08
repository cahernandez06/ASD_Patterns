package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSender implements IEmailSender {
	@Value("smtp.acme.com")
	String outgoingMailServer;//= "smtp.acme.com";//We will use primitive values injection++Classpath scanning 
	@Autowired
	private ILogger logger;   //= new Logger();   //We will use constructor injection+Classpath scanning

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
