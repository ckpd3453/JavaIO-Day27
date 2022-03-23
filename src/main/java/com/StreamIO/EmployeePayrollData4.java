package com.StreamIO;

import java.util.List;
import java.util.Scanner;

import com.StreamIO.EmployeePayRollService4.IOService;

public class EmployeePayrollData4 {
	public int id;
	public String name;
	public double salary;
	public EmployeePayrollData4(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public EmployeePayrollData4(List<EmployeePayrollData4> employeePayrollList) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "\nEmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public void readEmployeeData(Scanner consoleInputReader) {
		// TODO Auto-generated method stub
		
	}
	public void writeEmployeeData(IOService consoleIo) {
		// TODO Auto-generated method stub
		
	}
	
}
