import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import com.StreamIO.*;
import com.StreamIO.EmployeePayRollService4.IOService;


public class EmployeePayrollServiceTest {
	@Test
	/**
	 * method is created to find the number of entries given3Employees here When
	 * Written To File Should Match the EmployeeEntries
	 */
	public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {

		/**
		 * created the array of employee Payroll data to store the entries
		 */
		EmployeePayrollData4[] arrayOfEmp = { new EmployeePayrollData4(1, "Jeff Bezos", 100000.0),
				new EmployeePayrollData4(2, "Bill Gates", 200000.0),
				new EmployeePayrollData4(3, "Mark Zuckerberg", 300000.0) };
		EmployeePayRollService4 employeePayrollService;
		employeePayrollService = new EmployeePayRollService4(Arrays.asList(arrayOfEmp));

		/**
		 * calling the method writeEmployeeData from the IO_File
		 */
		employeePayrollService.writeEmployeeData(IOService.FILE_IO);

		/**
		 * calling the method countEntries from the IO_File
		 */
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		assertEquals(3, entries);
	}
}
