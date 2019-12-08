package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementService {
	
	@Async
	@EventListener
	public void advertise(AddCustomerEvent event) {
		System.out.println("Advertise received event: " + event.getMessage());
		
	}

}
