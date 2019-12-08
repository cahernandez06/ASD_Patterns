package mum.edu.asd.entity;

public interface FrequentFlyerState_Iface {
	
	void addFlight(FFAccount context, int newMiles);  //Handle method
	public void checkForUpgrade(FFAccount context);
}
