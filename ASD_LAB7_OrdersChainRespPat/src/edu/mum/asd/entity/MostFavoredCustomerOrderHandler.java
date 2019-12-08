package edu.mum.asd.entity;

import java.util.ArrayList;
import java.util.Collection;

public class MostFavoredCustomerOrderHandler extends OrderHandler{
    private Collection<Customer> customerlist = new ArrayList<Customer>();
    
	public MostFavoredCustomerOrderHandler(OrderHandler nexthandler) {
		super(nexthandler);
		
		Customer c1 = new Customer( "Carlos Hernandez");
		//Customer c2 = new Customer( "Tomas Hernandez");
		//Customer c3 = new Customer( "Martha Ramirez");
		
		customerlist.add(c1);
		//customerlist.add(c2);
		//customerlist.add(c3);
	}

	public void handleOrder(Order order) {
		boolean found = false;
		for (Customer cust : customerlist){
		   if (order.getCustomer().getName().equals(cust.getName())){
			   found=true;
			   System.out.println("Processing Most Favored Customer Order: "+order.getOrderNumber());
		   }
		}
		if (!found)
			nexthandler.handleOrder(order);
	}

}