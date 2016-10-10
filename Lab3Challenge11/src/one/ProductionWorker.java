package one;

import java.text.DecimalFormat;
import java.text.DateFormat;

public class ProductionWorker extends Employee {
	
	//Next, write a class named ProductionWorker that inherits from the Employee
	//class. The ProductionWorker class should have fields to hold the following
	//information: Shift (an integer), Hours pay rate (a double). The workday is
	//divided into two shifts: day and night. The shift field will be an integer
	//value representing the shift that the employee works. The day shift is shift
	//1 and the night shift is shift 2. Write one or more constructors and the
	//appropriate accessor and mutator methods for the class. Demonstrate the
	//classes by writing a program that uses a ProductionWorker object.
	
	public static final int DAY_SHIFT = 1;
	public static final int NIGHT_SHIFT = 2;
	private int shift;
	private double payRate;
	
	public ProductionWorker(String n, String num, String date, int sh, double rate) throws InvalidShift,InvalidPayRate, InvalidEmployeeNumber
	{
		super(n, num, date);
		shift = sh;
		payRate = rate;
		if(shift!=2&&shift!=1){
			throw new InvalidShift(shift);
			
			
		}
		if(payRate<0){
			throw new InvalidPayRate(payRate);
		}
			
	
}
	
	public ProductionWorker()
	{
		super();
		shift = DAY_SHIFT;
		payRate = 0.0;
	}
	
	public void setShift(int s)
	{
		shift = s;
	}
	
	public boolean setPayRate(double p)
	{
		payRate = p;
		return false;
	}
	
	public int getShift()
	{
		return shift;
	}
	
	public double getPayRate()
	{
		return payRate;
	}
	
	public String toString()
	{
		DecimalFormat dollars = new DecimalFormat("#,##0.00");
		
		String str = super.toString();
		
		str += "\nShift";
		if(shift == DAY_SHIFT)
			str += "Day";
		else if(shift == NIGHT_SHIFT)
			str += "Night";
		else
			str += "Invalid";
		
		str += ("\nHourly Pay Rate: $" + dollars.format(payRate));
		
		return str;
	}
}
