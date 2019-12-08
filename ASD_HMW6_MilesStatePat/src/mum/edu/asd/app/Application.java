package mum.edu.asd.app;

import mum.edu.asd.entity.FFAccount;

public class Application {
	public static void main(String[] args) {
		
		FFAccount ffaccount = new FFAccount("213425");
		System.out.println(ffaccount.getState().toString());
		
		ffaccount.addFlight(13000);
		System.out.println("Accountnr ="+ffaccount.getAccountNumber());
		System.out.println("Account type ="+ffaccount.getAccountType());
		System.out.println("miles ="+ffaccount.getNumberOfMiles());
		System.out.println("flights ="+ffaccount.getNumberOfFlights());
		ffaccount.addFlight(99000);
		System.out.println("Accountnr ="+ffaccount.getAccountNumber());
		System.out.println("Account type ="+ffaccount.getAccountType());
		System.out.println("miles ="+ffaccount.getNumberOfMiles());
		System.out.println("flights ="+ffaccount.getNumberOfFlights());
		ffaccount.addFlight(50000);
		System.out.println("Accountnr ="+ffaccount.getAccountNumber());
		System.out.println("Account type ="+ffaccount.getAccountType());
		System.out.println("miles ="+ffaccount.getNumberOfMiles());
		System.out.println("flights ="+ffaccount.getNumberOfFlights());
		ffaccount.addFlight(100); //This time *3 Miles and +2 fligths
		System.out.println("Accountnr ="+ffaccount.getAccountNumber());
		System.out.println("Account type ="+ffaccount.getAccountType());
		System.out.println("miles ="+ffaccount.getNumberOfMiles());
		System.out.println("flights ="+ffaccount.getNumberOfFlights());
	}
}