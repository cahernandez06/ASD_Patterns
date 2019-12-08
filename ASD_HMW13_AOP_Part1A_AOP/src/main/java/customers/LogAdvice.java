package customers;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAdvice {
	@After("execution(* customers.EmailSender.sendEmail(..))")
	public void logAfterMethod(JoinPoint joinPoint) {
		System.out.println(LocalDateTime.now() + " method: " + joinPoint.getSignature().getName());
	}

}
