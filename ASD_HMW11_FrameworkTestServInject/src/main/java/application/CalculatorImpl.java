package application;

import framework.Service;

@Service
public class CalculatorImpl implements Calculator{
	private int calcValue = 0;

	public void reset() {
		calcValue = 0;
	}

	public int add(int newValue) {
		calcValue = calcValue + newValue;
		return calcValue;
	}

	public int substract(int newValue) {
		calcValue = calcValue - newValue;
		return calcValue;
	}

}
