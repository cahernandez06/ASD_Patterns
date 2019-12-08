package customers;

public class AddCustomerEvent {
	private String message;
	
	public AddCustomerEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
