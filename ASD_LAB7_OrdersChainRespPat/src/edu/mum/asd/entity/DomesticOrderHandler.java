package edu.mum.asd.entity;

public class DomesticOrderHandler extends OrderHandler{
    
	public DomesticOrderHandler(OrderHandler nexthandler) {
		super(nexthandler);
	}

	public void handleOrder(Order order) {
		System.out.println("Processing Domestic Order: " + order.getOrderNumber());
	}

}