package one;

import java.util.Scanner;

public class Demo {
	public static void main(String[]args) throws InvalidShift, InvalidPayRate, InvalidEmployeeNumber
	{
		String employeeName, employeeNumber, hireDate;
		int shift;
		double payRate;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		employeeName = scan.nextLine();
		
		System.out.println("Enter your employee number: ");
		boolean isValid = false;
		employeeNumber = scan.nextLine();
		while(!isValid){
			Employee em = new Employee();
			isValid = em.isValidENumb(employeeNumber);
			if(!isValid){
				System.out.println("Invalid employee number:" + employeeNumber);
				System.out.println("Try again. Enter your employee number: ");
				employeeNumber = scan.nextLine();
			}
		}
		
		System.out.println("Enter the date you were hired: ");
		hireDate = scan.nextLine();
		
		System.out.println("Enter your payrate: ");
		try{
			payRate = scan.nextDouble();
		}
		catch(Exception e){
			System.out.println("That is not a number silly. Did you want to get"
					+ " paid in letters?");
			scan.next();
			payRate = 0.0;
		}
		
		System.out.println("Enter your shift(enter 1 for day or 2 for night): ");
		shift = scan.nextInt();
		
		ProductionWorker p = new ProductionWorker(employeeName, employeeNumber,
				hireDate, shift, payRate);
		
		System.out.println("Name: " + p.getEmployeeName());
		System.out.println("Employee Number: " + p.getEmployeeNumber());
		System.out.println("Hire Date: " + p.getHireDate());
		System.out.println("Pay Rate: $" + p.getPayRate());
		System.out.println("Shift: " + p.getShift());
	}
}
