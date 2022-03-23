package com.StreamIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService3 {

	/**
	 * Java Enums can be thought of as classes which have a fixed set of constants
	 * (a variable that does not change) we can define an enum either inside the
	 * class or outside the class
	 */
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	/**
	 * creating List of EmployeePayrollData
	 */
	private List<EmployeePayrollData3> employeePayrollList;

	/**
	 * creating constructor of EmployeePayrollService() which is default type
	 */
	public EmployeePayRollService3() {
	}

	/**
	 * creating parameterized constructor of EmployeePayrollService with no return
	 * type
	 * 
	 * @param employeePayrollList -passing parameter
	 */
	public EmployeePayRollService3(List<EmployeePayrollData3> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * Main method for manipulation Of JavaFILE_IO
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) {
		
		// creating List of Type EmployeePayrollData using ArrayList to store all the employeePayrolldata
		List<EmployeePayrollData3> employeePayrollList = new ArrayList<EmployeePayrollData3>();

		// creating instance of EmployeePayrollData class
		EmployeePayRollService3 employeePayrollService = new EmployeePayRollService3(employeePayrollList);

		// using scanner to read input from console
		Scanner consoleInputReader = new Scanner(System.in);

		// Calling method readEmployeeData to read data from console
		employeePayrollService.readEmployeeData(consoleInputReader);

		// Calling method writeEmployeePayrollData to write the data
		employeePayrollService.writeEmployeeData();
	}

	/**
	 * @param consoleInputReader Read employee data
	 */
	private void readEmployeeData(Scanner consoleInputReader) {
		System.out.println("Enter employee ID : ");
		int id = Integer.parseInt(consoleInputReader.nextLine());
		System.out.println("Enter employee name : ");
		String name = consoleInputReader.nextLine();
		System.out.println("Enter employee salary : ");
		double salary = Double.parseDouble(consoleInputReader.nextLine());

		/**
		 * Adding EmployeePayrollData to the employeepayrollList
		 */
		employeePayrollList.add(new EmployeePayrollData3(id, name, salary));
	}

	/**
	 * created method writeEmployeeData which writes the data of the employee in the
	 * console
	 */
	private void writeEmployeeData() {
		System.out.println("Writing Employee Payroll Data to Console\n" + employeePayrollList);
	}
}
