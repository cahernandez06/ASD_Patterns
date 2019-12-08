package mum.edu.asd.entity;

public class PlatinumState implements FrequentFlyerState_Iface{

	@Override
	public void addFlight(FFAccount context, int newMiles) {
		// Platinum increments Miles per 3 factor and number of flights + 2
		context.setNumberOfMiles(context.getNumberOfMiles()+(newMiles*3));
		context.setNumberOfFlights(context.getNumberOfFlights()+2);
	}

	@Override
	public void checkForUpgrade(FFAccount context) {
		// No other state to promote
		System.out.println("You are in the maximum category");
	}

	public String toString(){
	      return "is Platino";
	   }
}
