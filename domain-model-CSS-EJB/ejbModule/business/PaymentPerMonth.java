package business;

import java.util.Arrays;
import java.util.List;

public class PaymentPerMonth {

	private List<Double> months;
	
	private int year;
	
	public PaymentPerMonth(int year) {
		this.year = year;
		months = Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
	}
	
	public void setValue(int month, double value) {
		months.set(month, value);
	}
	
	public double getValue(int month) {
		return months.get(month);
	}
	
}
