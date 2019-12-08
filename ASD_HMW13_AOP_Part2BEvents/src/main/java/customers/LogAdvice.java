package customers;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAdvice {
	@After("execution(* customers.EmailSender.sendEmail(..)) && args(email,message)")
	public void logAfterMethod(JoinPoint joinPoint, String email, String message) {
		EmailSender emailSender = (EmailSender) joinPoint.getTarget();
		String outMailServer = emailSender.getOutgoingMailServer();
		System.out.println(LocalDateTime.now() + " method= " + joinPoint.getSignature().getName() + 
				" address= " + email + " message= " + message + " ,outgoing mail server= " + outMailServer);
	}

}
