package mum.edu.asd.entity;

public class FFAccount {
	private String accountNumber;
	private String accountType;
	private int numberOfMiles;
	private int numberOfFlights;
	private FrequentFlyerState_Iface CurrentState;
	
	public FFAccount(String aNumber) {
		accountNumber=aNumber;
		accountType="silver";
		CurrentState = new SilverState();
	}
	
	public void setState(FrequentFlyerState_Iface state) {
		this.CurrentState = state;
	}
	
	public FrequentFlyerState_Iface getState() {
		return CurrentState;
	}
	
	public void addFlight(int newMiles){
		
		CurrentState.addFlight(this, newMiles);
		checkForUpgrade();	//To do automatically the upgrade of category
		
		/*if (accountType.equals("silver")){
			numberOfMiles+=newMiles;
			numberOfFlights++;
			checkForUpgrade();
		}
		else{
			if (accountType.equals("gold")){
				numberOfMiles+=(2*newMiles);
				numberOfFlights++;
			}
		}*/
	}
	
	public void checkForUpgrade(){
		
		CurrentState.checkForUpgrade(this);
		/*if ((numberOfMiles > 100000)|| (numberOfFlights > 95)){
			accountType ="gold" ;
		}*/
	}
	
	public String getAccountType() {
		return accountType;
		}
	
	public void setAccountType(String accountType){
		this.accountType = accountType;
		}
	
	public int getNumberOfMiles() {
		return numberOfMiles;
		}
	
	public int getNumberOfFlights() {
		return numberOfFlights;
		}
	
	public String getAccountNumber() {
		return accountNumber;
		}
	
	public void setAccountNumber(String accountNumber)	{
		this.accountNumber = accountNumber;
		}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}
	
	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}
}