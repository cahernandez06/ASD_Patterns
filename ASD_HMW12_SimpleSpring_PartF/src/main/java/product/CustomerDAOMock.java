package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("two")
public class CustomerDAOMock implements ICustomerDAO{
	@Autowired
	private ILogger logger; // = new Logger(); We will use Constructor injection for this+Classpath scanning
	
	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAOMock: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

	public CustomerDAOMock(ILogger logger) {
		this.logger = logger;
	}

}