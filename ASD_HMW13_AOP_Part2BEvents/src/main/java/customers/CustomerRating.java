package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomerRating {
	
	@Async
	@EventListener
	public void rating(AddCustomerEvent event) {
		System.out.println("Rating received event: " + event.getMessage());
		
	}

}