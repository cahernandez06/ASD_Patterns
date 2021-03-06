package customers;

public class CustomerDAO implements ICustomerDAO{
	private ILogger logger; // = new Logger(); We will use Constructor injection for this+Classpath scanning
	
	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

	public CustomerDAO(ILogger logger) {
		this.logger = logger;
	}

}
