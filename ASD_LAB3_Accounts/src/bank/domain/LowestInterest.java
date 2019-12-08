package bank.domain;

public class LowestInterest implements Strategy{

	public double computeInterest(double balance) {
		
		if(balance < 1000) {
			
			return balance * 0.015;
			
		}
		
		else 
			return 0.025;
		
	}

}