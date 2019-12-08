package bank.domain;

public class HigestInterest implements Strategy {

	public double computeInterest(double balance) {
		
		if (balance < 1000) {
			
			return balance * 0.01;
		}
		
		else if ((balance >1000) && (balance < 5000)) {
			
			return balance * 0.02;
		}
		
		else
			return 0.04;
	}

}