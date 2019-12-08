package customers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
	
	@EventListener
	public void onEvent(AddCustomerEvent event) {
		System.out.println("received event: " + event.getMessage());
		
	}

}
