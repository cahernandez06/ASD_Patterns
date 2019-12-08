package edu.mum.asd.entity;

public class InternationalOrderHandler extends OrderHandler{
    
	public InternationalOrderHandler(OrderHandler nexthandler) {
		super(nexthandler);
	}

	public void handleOrder(Order order) {
		boolean exist = false;
		if (order.isInternational()){
			exist=true;
			System.out.println("Processing International Order: " + order.getOrderNumber());
		}
		else {
			nexthandler.handleOrder(order);
		}
			
	}

	
}