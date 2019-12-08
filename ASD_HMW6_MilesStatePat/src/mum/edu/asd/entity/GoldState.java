package mum.edu.asd.entity;

public class GoldState implements FrequentFlyerState_Iface {

	@Override
	public void addFlight(FFAccount context, int newMiles) {
		// Gold increments Miles per 2 factor and number of flights + 1
		context.setNumberOfMiles(context.getNumberOfMiles()+(newMiles*2));
		context.setNumberOfFlights(context.getNumberOfFlights()+1);
	}

	@Override
	public void checkForUpgrade(FFAccount context) {
		// Checks if has to be promoted to Platinum
		if ((context.getNumberOfMiles() > 150000)||(context.getNumberOfFlights() > 145)) {
			context.setState(new PlatinumState());
			context.setAccountType("Platinum");
		}
	}
	
	public String toString(){
	      return "is Gold";
	   }
}
