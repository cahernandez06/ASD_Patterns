package edu.mum.asd.app;

import edu.mum.asd.entity.Customer;
import edu.mum.asd.entity.DomesticOrderHandler;
import edu.mum.asd.entity.InternationalOrderHandler;
import edu.mum.asd.entity.LargeOrderHandler;
import edu.mum.asd.entity.MostFavoredCustomerOrderHandler;
import edu.mum.asd.entity.Order;

public class Application {


	public static void main(String[] args) {

		DomesticOrderHandler domesticOrderHandler = new DomesticOrderHandler(null);
		InternationalOrderHandler internationalOrderHandler = new InternationalOrderHandler(domesticOrderHandler);
		LargeOrderHandler largeOrderHandler = new LargeOrderHandler(internationalOrderHandler);
		MostFavoredCustomerOrderHandler mostFavoredCustomerOrderHandler = new MostFavoredCustomerOrderHandler(largeOrderHandler);
		
		Customer c1 = new Customer( "Carlos Hernandez");
		Customer c2 = new Customer( "Tomas Hernandez");
		Customer c3 = new Customer( "Martha Ramirez");
		Customer c4 = new Customer( "Salome Ramirez");
		
		Order order1 = new Order ("1", 30000, true,c1);     //Carlos order
		Order order2 = new Order ("2", 300000, true, c2);   //Tomas order
		Order order3 = new Order ("3", 30000, true, c3);    //Martha's order
		Order order4 = new Order ("4", 30000, false, c3);   //Salome's order
		
		mostFavoredCustomerOrderHandler.handleOrder(order1);
		mostFavoredCustomerOrderHandler.handleOrder(order2);
		mostFavoredCustomerOrderHandler.handleOrder(order3);
		mostFavoredCustomerOrderHandler.handleOrder(order4);
		
	}

}