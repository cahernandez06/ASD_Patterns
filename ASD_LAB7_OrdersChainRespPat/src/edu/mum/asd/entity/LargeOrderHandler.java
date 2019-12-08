package edu.mum.asd.entity;


public class LargeOrderHandler extends OrderHandler{
    
	public LargeOrderHandler(OrderHandler nexthandler) {
		super(nexthandler);
	}

	public void handleOrder(Order order) {
		if (order.getTotalamount()> 100000.0){
			System.out.println("Processing Large Order: " + order.getOrderNumber());
		}
		else
			nexthandler.handleOrder(order);
	}

}