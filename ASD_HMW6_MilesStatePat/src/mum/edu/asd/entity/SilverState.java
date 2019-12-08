package mum.edu.asd.entity;

public class SilverState implements FrequentFlyerState_Iface{

	@Override
	public void addFlight(FFAccount context, int newMiles) {
		// Silver increments Miles per 1 factor and number of flights + 1
		context.setNumberOfMiles(context.getNumberOfMiles()+newMiles);
		context.setNumberOfFlights(context.getNumberOfFlights()+1);
	}

	@Override
	public void checkForUpgrade(FFAccount context) {
		// Checks if has to be promoted to Gold
		if ((context.getNumberOfMiles() > 75000)||(context.getNumberOfFlights() > 75)) {
			context.setState(new GoldState());
			context.setAccountType("Gold");
		}
	}
	
	public String toString(){
	      return "is Silver";
	   }
}
