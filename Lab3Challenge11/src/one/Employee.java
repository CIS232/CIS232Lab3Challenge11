package one;

public class Employee {

	//Design a class named Employee. The class should keep the following
	//information in fields: Employee name, Employee number in the format
	//XXX-L, where each X is a digit within the range 0-9 and the L is a letter
	//within the range A-M, Hire date. Write one or more constructors and the
	//appropriate accessor and mutator methods for the class.
		
	String employeeName, employeeNumber, hireDate;

	
	public Employee(String n, String en, String h)throws InvalidEmployeeNumber  //initialize object, 
, InvalidShift
	{
		employeeName = n;
		employeeNumber = en;
		hireDate = h;
		// checking employeenumber
		if(!isValidENumb(employeeNumber)){
			throw new InvalidEmployeeNumber(employeeNumber);
		}
		
	}
	
	public Employee()
	{
		employeeName = "";
		employeeNumber = "";
		hireDate = "";
	}
	
	public void setName(String n)
	{
		employeeName = n;
	}
	
	public void setEmployeeNumber(String en)
	{
		if(isValidENumb(en))
		{
			employeeNumber = en;
		}
		else
		{
			employeeNumber = "";
		}
	}
	
	public void setHireDate(String h)
	{
		hireDate = h;
	}
	
	public String getEmployeeName()
	{
		return employeeName;
	}
	
	public String getEmployeeNumber()
	{
		return employeeNumber;
	}
	
	public String getHireDate()
	{
		return hireDate;
	}
	
	public boolean isValidENumb(String e)
	{
		boolean status = true;
		
		if(e.length()!= 5)
			status = false;
		else
		{
			if ((!Character.isDigit(e.charAt(0))) || //if first-third character is
			   ((!Character.isDigit(e.charAt(1)))) || //not a digit, fourth is not
			   ((!Character.isDigit(e.charAt(2)))) || //a dash, and fifth is not a
			 	 (e.charAt(3) != '-')||				  //letter a-m then return false
			 	
			   (!(e.charAt(4)>= 'A' || e.charAt(4)<= 'M')))
			{
				status = false;
			}
		}
		return status;
	}
	
	public String toString()
	{
		String str = "Name: " + employeeName + "\nEmployee Number: ";
		
		if (employeeNumber == "")
		{
			str += "Invalid number";
		}
		else
		{
			str += employeeNumber;
		}
		
		str += ("\nHire Date: " + hireDate);
		return str;
	}
}
